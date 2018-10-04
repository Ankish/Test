package com.aswin.testapp.fragments;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.aswin.testapp.R;
import com.aswin.testapp.adapters.ViewPagerAdapter;
import com.aswin.testapp.base.BaseFragment;

public class FragmentView extends BaseFragment implements ViewPager.OnPageChangeListener {
    private ViewPager viewPager;
    private LinearLayout pagerIndicator;
    private ViewPagerAdapter pagerAdapter;
    private ImageView[] dots;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_view, container, false);
        initView(view);
        return view;
    }

    private void initView(View view) {
        viewPager = (ViewPager) view.findViewById(R.id.viewPager);
        pagerIndicator = (LinearLayout) view.findViewById(R.id.pager_indicator);
        pagerAdapter = new ViewPagerAdapter(getActivity(), 5);
        viewPager.setAdapter(pagerAdapter);
        viewPager.setCurrentItem(0);
        viewPager.addOnPageChangeListener(this);
        createIndicator();
    }

    private void createIndicator() {
        int count = pagerAdapter.getCount();
        dots = new ImageView[count];

        for (int i = 0; i < count; i++) {
            dots[i] = new ImageView(getActivity());
            dots[i].setImageDrawable(getResources().getDrawable(R.drawable.unselected_item));

            LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);
            params.setMargins(4, 0, 4,0);

            pagerIndicator.addView(dots[i], params);
        }

        dots[0].setImageDrawable(getResources().getDrawable(R.drawable.selected_item));
    }

    @Override
    public void onPageScrolled(int i, float v, int i1) {

    }

    @Override
    public void onPageSelected(int i) {
        for (int j = 0; j < pagerAdapter.getCount(); j++) {
            dots[j].setImageDrawable(getResources().getDrawable(R.drawable.unselected_item));
        }
        dots[i].setImageDrawable(getResources().getDrawable(R.drawable.selected_item));

    }

    @Override
    public void onPageScrollStateChanged(int i) {

    }
}
