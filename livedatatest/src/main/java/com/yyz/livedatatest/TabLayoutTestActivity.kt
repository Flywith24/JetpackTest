package com.yyz.livedatatest

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import androidx.viewpager.widget.ViewPager
import com.google.android.material.tabs.TabLayout

/**
 * @author yyz (杨云召)
 * @date   2019/12/19
 * time   17:22
 * description
 */
class TabLayoutTestActivity : AppCompatActivity() {

    private lateinit var mTabLayout: TabLayout
    private lateinit var mViewPager: ViewPager
    private val titles = arrayOf("推荐应用", "必装应用", "应用管理")


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_tablayout_test)

        mViewPager = findViewById<ViewPager>(R.id.viewPager).apply {
            offscreenPageLimit = 3
            adapter = PageAdapter(supportFragmentManager)
            addOnPageChangeListener(object : ViewPager.SimpleOnPageChangeListener() {
                override fun onPageSelected(position: Int) {
                    mTabLayout.setScrollPosition(position, 0f, true)
                }
            })
        }

        mTabLayout = findViewById<TabLayout>(R.id.tab_layout).apply {
            setupWithViewPager(mViewPager)
            tabMode = TabLayout.MODE_FIXED
            addOnTabSelectedListener(object : TabLayout.OnTabSelectedListener {
                override fun onTabSelected(tab: TabLayout.Tab) {
//                    mViewPager.currentItem = tab.position
                }

                override fun onTabUnselected(tab: TabLayout.Tab) {}
                override fun onTabReselected(tab: TabLayout.Tab) {}
            })
            //setupWithViewPager tabLayout与viewpager联动后,标题会由getPageTitle控制，移除所有tab，使用自定义view的tab
            removeAllTabs()
            for (i in titles.indices) {
     /*           addTab(newTab().apply {
                    customView =
                        View.inflate(this@TabLayoutTestActivity, R.layout.layout_tab, null).apply {
                            findViewById<AppCompatTextView>(R.id.tv_title).text = titles[i]
                        }
                }) */
                addTab(newTab().apply {
                    text = titles[i]
                })
            }
        }

    }

    inner class PageAdapter(fm: FragmentManager) :
        FragmentPagerAdapter(fm, BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT) {

        override fun getItem(position: Int): Fragment =
            ContentFragment.newInstance(titles[position])

        override fun getCount(): Int = titles.size
    }
}