package demo.techinasia.com.myapplication.demo.presentation;

import dagger.Component;
import demo.techinasia.com.myapplication.demo.dependency.component.AppComponent;
import demo.techinasia.com.myapplication.demo.dependency.module.MockProductActivityModule;
import demo.techinasia.com.myapplication.demo.dependency.module.MockProductActivityStubModule;
import demo.techinasia.com.myapplication.demo.qualifier.ApplicationScope;

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

@ApplicationScope
@Component(modules = {
        MockProductActivityStubModule.class,
        MockProductActivityModule.class
}, dependencies = {AppComponent.class})
public interface MockComponent {

    void inject(ApplicationStub application);
}
