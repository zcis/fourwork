package com.example.a86130.zhangmiaoyin.activity;

import androidx.viewpager.widget.ViewPager;
import butterknife.BindView;
import android.util.Log;

import com.example.a86130.zhangmiaoyin.R;
import com.example.a86130.zhangmiaoyin.adapter.HomeVpAdapter;
import com.example.a86130.zhangmiaoyin.base.BaseActivity;
import com.example.a86130.zhangmiaoyin.fragment.HomeFragmet;
import com.google.android.material.bottomnavigation.BottomNavigationView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends BaseActivity {

    @BindView(R.id.home_viewpager)
    ViewPager mViewPager;
    @BindView(R.id.home_navigation)
    BottomNavigationView mBottomNv;


    @Override
    protected void initListenner() {
        mBottomNv.setOnNavigationItemSelectedListener(menuItem -> {
            switch (menuItem.getItemId()) {
                case R.id.item_home:
                    Log.e("TAG", "00000000");
                    switchTab(0);
                    break;
                case R.id.item_navigation:
                    Log.e("TAG", "111111111");
                    switchTab(1);
                    break;
                case R.id.item_tixi:
                    Log.e("TAG", "222222222");
                    switchTab(2);
                    break;
                case R.id.item_gongzhonghao:
                    switchTab(3);
                    break;
            }
            return true;
        });
        mViewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                //当ViewPager页面切换的时候让下面的tab标签跟着切换
                mBottomNv.getMenu().getItem(position).setChecked(true);
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
    }

    private void switchTab(int i) {
        mViewPager.setCurrentItem(i);
    }

    @Override
    protected void onViewCreated() {
        List<HomeFragmet> fragments = getHomeFragmets();
        HomeVpAdapter adapter = new HomeVpAdapter(getSupportFragmentManager(), fragments);
        mViewPager.setAdapter(adapter);
    }

    private List<HomeFragmet> getHomeFragmets() {
        List<HomeFragmet> fragments = new ArrayList<HomeFragmet>();
        for (int i = 0; i < 4; i++) {
            HomeFragmet homeFragmet = new HomeFragmet(i);
            fragments.add(homeFragmet);
        }
        return fragments;
    }

    @Override
    protected int getLayout() {
        return R.layout.activity_main;
    }

}
