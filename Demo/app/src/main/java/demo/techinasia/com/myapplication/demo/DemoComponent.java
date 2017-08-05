package demo.techinasia.com.myapplication.demo;

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

import dagger.Component;
import demo.techinasia.com.myapplication.demo.dependency.component.AppComponent;
import demo.techinasia.com.myapplication.demo.dependency.module.NetworkModule;
import demo.techinasia.com.myapplication.demo.dependency.module.ProductActivityModule;
import demo.techinasia.com.myapplication.demo.qualifier.ApplicationScope;

@ApplicationScope
@Component(modules = {
        NetworkModule.class,
        ProductActivityModule.class
}, dependencies = {AppComponent.class})
public interface DemoComponent {

    void inject(DemoApplication application);
}
