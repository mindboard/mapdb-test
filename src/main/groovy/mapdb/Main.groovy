package mapdb

import org.mapdb.DBMaker

class Main {
    static void main(String[] args){
        def cacheDbFile = new File('cache.db')

        boolean firstTime = false
        if( !cacheDbFile.exists() ){
            firstTime = true
        }

        def db  = DBMaker.fileDB(cacheDbFile).closeOnJvmShutdown().make()
        def map = db.hashMap("map").createOrOpen()

        if( firstTime ){
            // 初回時 -> データを作成
            map.put('key1','hello')
            map.put('key2','hello world')
        }
        else {
            // 二回目以後 -> 内容を確認
            println map.get('key1')
            println map.get('key2')
        }
    }
}
