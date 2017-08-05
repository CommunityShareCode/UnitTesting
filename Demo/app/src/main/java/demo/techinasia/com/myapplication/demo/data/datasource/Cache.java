package demo.techinasia.com.myapplication.demo.data.datasource;

import java.util.List;

import demo.techinasia.com.myapplication.demo.data.model.Model;

/**
 * Created by fandygotama on 8/5/17.
 * With special thanks to (Alphabetical Order):
 * - Aldy Chrissandy (Indonesia),
 * - Antoni Tirta Riady (Indonesia),
 * - Arman Hendra Harnanda (Indonesia),
 * - Jessa Cahilig (Philippines),
 * - Remerico Cruz (Philippines),
 * - Steven Lewi (Indonesia),
 * For being great teams and excellent collaborators, and
 * also to Rendra Toro for being our Manager.
 * OLX SEA MOBILE APPS TEAM 2016, YOU GUYS ARE AWESOME!!
 */

public interface Cache<T extends Model> {

    T get(T request);

    List<T> getList(T model);

    void put(T model);

    void putList(List<T> models);

    void update(T model);

    boolean isCached(T model);

    boolean isExpired(T model);

    void remove(T model);

    void removeAll();
}
