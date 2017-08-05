package demo.techinasia.com.myapplication.demo.presentation.presenter;

import android.support.annotation.NonNull;

import demo.techinasia.com.myapplication.demo.presentation.view.View;

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

public interface Presenter<T extends View> {
    void attachView(@NonNull T view);
    void detachView();
}
