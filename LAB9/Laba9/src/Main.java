import rx.*;
import rx.subjects.BehaviorSubject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.*;

public class Main {
    public static void main(String[] args) {


        BehaviorSubject<Integer> a = BehaviorSubject.create();
        BehaviorSubject<Integer> b = BehaviorSubject.create();
        Observable<Integer> c = Observable.combineLatest(a,b,(i1,i2) -> i1+i2);
        c.subscribe (System.out::println);
        a.onNext(10);
        b.onNext(10);
        a.onNext(20);

            BehaviorSubject<Integer> x = BehaviorSubject.create();
            BehaviorSubject<Integer> y = BehaviorSubject.create();
            Observable<Integer> z = Observable.combineLatest(x,y,(i1,i2) -> i1+i2);
            Observable<Integer> cIn2 = z.map(i->i*i).filter(i->i%2 == 0);
            cIn2.subscribe (System.out::println);
            x.onNext(1);
            y.onNext(2);
            x.onNext(2);
            x.onNext(3);
            x.onNext(4);
    }
}
