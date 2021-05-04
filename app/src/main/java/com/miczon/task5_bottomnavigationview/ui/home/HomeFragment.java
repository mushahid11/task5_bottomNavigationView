package com.miczon.task5_bottomnavigationview.ui.home;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.viewpager.widget.ViewPager;

import com.google.android.material.tabs.TabLayout;
import com.miczon.task5_bottomnavigationview.BlankFragment1;
import com.miczon.task5_bottomnavigationview.BlankFragment2;
import com.miczon.task5_bottomnavigationview.R;
import com.miczon.task5_bottomnavigationview.ViewPagerAdapter2;
import com.miczon.task5_bottomnavigationview.ui.dashboard.DashboardFragment;
import com.miczon.task5_bottomnavigationview.ui.notifications.NotificationsFragment;

public class HomeFragment extends Fragment {
    private TabLayout tabLayout;
    private ViewPager viewPager;
    private ViewPagerAdapter2 viewPagerAdapter;
    public HomeFragment() {
    }

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_home, container, false);

        tabLayout = view.findViewById(R.id.tab_layout_fragmentFirstt);
        viewPager = view.findViewById(R.id.viewpager_fragmentFirstt);


        // setting/Initializing up the adapter
        viewPagerAdapter = new ViewPagerAdapter2(getChildFragmentManager());
        setupViewPager(viewPager);

        // The Page (fragment) titles will be displayed in the
        // tabLayout hence we need to  set the page viewer
        // we use the setupWithViewPager().
        tabLayout.setupWithViewPager(viewPager);

        //setting icons
        tabLayout.getTabAt(0).setText("fragment1");
        tabLayout.getTabAt(1).setText("fragment2");
        return view;
    }


    // add the fragments
    private void setupViewPager(ViewPager viewPager) {
        ViewPagerAdapter2 adapter = new ViewPagerAdapter2(getChildFragmentManager());
        adapter.addFragment(new BlankFragment1(), "Fragment1");
        adapter.addFragment(new BlankFragment2(), "Fragment2");
        viewPager.setAdapter(adapter);
    }
}