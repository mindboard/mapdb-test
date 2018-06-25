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
            // create db and contents.
            map.put('key1','hello')
            map.put('key2','hello world')
        }
        else {
            // output contents.
            println map.get('key1')
            println map.get('key2')
        }
    }
}
