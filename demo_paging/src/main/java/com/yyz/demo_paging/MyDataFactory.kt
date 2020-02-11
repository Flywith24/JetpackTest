package com.yyz.demo_paging

import androidx.paging.DataSource

/**
 * @author yyz (杨云召)
 * @date   2020-02-11
 * time   16:28
 * description
 */
class MyDataFactory : DataSource.Factory<Int, Api.Data>() {
    override fun create(): DataSource<Int, Api.Data> {
        return MyDataSource()
    }
}