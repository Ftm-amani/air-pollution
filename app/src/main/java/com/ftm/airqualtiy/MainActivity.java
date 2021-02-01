package com.ftm.airqualtiy;

import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;


import com.ftm.airqualtiy.databinding.ActivityMainBinding;
import com.ftm.airqualtiy.model.ResponseAirHere;
import com.ftm.airqualtiy.model.search.ResponseSearch;
import com.ftm.airqualtiy.remote.ApiService;
import com.ftm.airqualtiy.remote.RetrofitClient;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {
    public static final String TOKEN = "70880f2035f49a6bf9d1cb49088c2781626b6c29";
    ApiService apiService;
    ActivityMainBinding binding;
    boolean isSearchOpen = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main);

        apiService = RetrofitClient.getClient().create(ApiService.class);

        getHereData();


        binding.imgRefresh.setOnClickListener(v -> getHereData());


        binding.btnSearchIcon.setOnClickListener(v -> {

            if (isSearchOpen) {
                binding.llSearch.setVisibility(View.GONE);
                binding.btnSearchIcon.setImageResource(R.drawable.ic_search_black_24dp);
                isSearchOpen = false;
            } else {
                binding.llSearch.setVisibility(View.VISIBLE);
                binding.btnSearchIcon.setImageResource(R.drawable.ic_close);
                isSearchOpen = true;
            }

        });

        binding.btnSearch.setOnClickListener(v -> {
            if (binding.btnSearch.getText().toString().length() > 0) {
                binding.pbSearch.setVisibility(View.VISIBLE);
                binding.tvWeatherQuality.setVisibility(View.INVISIBLE);
                getSearchData(binding.etSearch.getText().toString());
            }
        });

    }


    private void getSearchData(String keyWord) {

        apiService.getSearchData(keyWord, TOKEN).enqueue(new Callback<ResponseSearch>() {
            @Override
            public void onResponse(Call<ResponseSearch> call, Response<ResponseSearch> response) {
                if (response.body().getData() != null) {
                    binding.pbSearch.setVisibility(View.GONE);
                    binding.tvWeatherQuality.setVisibility(View.VISIBLE);

                    showSearchData(response.body());
                }
            }

            @Override
            public void onFailure(Call<ResponseSearch> call, Throwable t) {

            }
        });


    }

    private void showSearchData(ResponseSearch responseSearch) {

        binding.tvWeatherIndex.setText(String.valueOf(responseSearch.getData().get(0).getAqi()));
        calcAiryQualityLevel(Integer.valueOf(responseSearch.getData().get(0).getAqi()));


    }


    private void getHereData() {

        showLoading(true);

        apiService.getHereAirQuality(TOKEN).enqueue(new Callback<ResponseAirHere>() {
            @Override
            public void onResponse(Call<ResponseAirHere> call, Response<ResponseAirHere> response) {
                showReceivedData(response.body());
                showLoading(false);

            }

            @Override
            public void onFailure(Call<ResponseAirHere> call, Throwable t) {
                Toast.makeText(MainActivity.this, " خطا در ارتباط با سرور", Toast.LENGTH_SHORT);
            }
        });


    }

    private void showReceivedData(ResponseAirHere responseAirHere) {
        binding.tvCity.setText(responseAirHere.getData().getCity().getName());

        if (responseAirHere.getData().getIaqi() != null && responseAirHere.getData().getIaqi().getT() != null) {
            binding.tvTemp.setText(String.valueOf(responseAirHere.getData().getIaqi().getT().getV()));
        }

        if (responseAirHere.getData().getIaqi() != null && responseAirHere.getData().getIaqi().getP() != null) {
            binding.tvPressure.setText(String.valueOf(responseAirHere.getData().getIaqi().getP().getV()));
        }

        if (responseAirHere.getData().getIaqi() != null && responseAirHere.getData().getIaqi().getPm10() != null) {
            binding.tvPm10Number.setText(String.valueOf(responseAirHere.getData().getIaqi().getPm10().getV()));
        }

        if (responseAirHere.getData().getIaqi() != null && responseAirHere.getData().getIaqi().getPm25() != null) {
            binding.tvPm25Number.setText(String.valueOf(responseAirHere.getData().getIaqi().getPm25().getV()));

        }

        binding.tvWeatherIndex.setText(String.valueOf(responseAirHere.getData().getAqi()));
        calcAiryQualityLevel(responseAirHere.getData().getAqi());

    }


    private void calcAiryQualityLevel(int aqi) {
        String quality;
        int headerBg;
        if (aqi <= 50) {
            quality = "بسیار سالم";
            headerBg = R.drawable.header_background;
        } else if (aqi <= 100) {
            quality = "سالم";
            headerBg = R.drawable.header_background;
        } else if (aqi <= 150) {
            quality = "ناسالم برای گروه حساس";
            headerBg = R.drawable.header_background_warn;
        } else if (aqi <= 200) {
            quality = "ناسالم";
            headerBg = R.drawable.header_background_error;
        } else if (aqi <= 300) {
            quality = "بسیار ناسالم";
            headerBg = R.drawable.header_background_error;
        } else {
            quality = "بسیار خطرناک";
            headerBg = R.drawable.header_background_error;
        }

        binding.tvWeatherQuality.setText(quality);
        binding.constraintLayoutHeader.setBackgroundResource(headerBg);

    }

    private void showLoading(boolean isShow) {
        if (isShow) {
            binding.rlLoading.setVisibility(View.VISIBLE);
        } else {
            binding.rlLoading.setVisibility(View.GONE);
        }
    }
}
