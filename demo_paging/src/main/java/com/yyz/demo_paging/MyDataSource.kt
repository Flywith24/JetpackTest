package com.yyz.demo_paging

import androidx.paging.PageKeyedDataSource
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.MainScope
import kotlinx.coroutines.launch

/**
 * @author yyz (杨云召)
 * @date   2020-02-11
 * time   16:08
 * description
 */
class MyDataSource : PageKeyedDataSource<Int, Api.Data>(), CoroutineScope by MainScope() {
    private val api = Api.create()
    override fun loadInitial(
        params: LoadInitialParams<Int>,
        callback: LoadInitialCallback<Int, Api.Data>
    ) {
        launch {
            val result = api.getHomeArticleList(0).data!!
            callback.onResult(result.datas, null, result.curPage)
        }
    }

    override fun loadAfter(params: LoadParams<Int>, callback: LoadCallback<Int, Api.Data>) {
        launch {
            val result = api.getHomeArticleList(pageSize = params.key).data!!
            //pass the key for the next page, or null if the loaded page is the last.
            val adjacentPageKey = if (result.over) null else result.curPage
            callback.onResult(result.datas, adjacentPageKey)
        }
    }

    override fun loadBefore(params: LoadParams<Int>, callback: LoadCallback<Int, Api.Data>) {
        launch {
            val result = api.getHomeArticleList(pageSize = params.key).data!!
            //pass the key for the previous page, or {@code null} if the loaded page is the first.
            val adjacentPageKey = if (params.key > 1) params.key - 1 else null
            callback.onResult(result.datas, adjacentPageKey)
        }
    }
}
