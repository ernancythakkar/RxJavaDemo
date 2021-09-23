# RxJavaDemo

RxJava is a Java VM implementation of ReactiveX (Reactive Extensions): a library for composing asynchronous and event-based programs by using observable sequences.

<h2>Build blocks for RxJava </h2>
The build blocks for RxJava code are the following:

- observables representing sources of data

- subscribers (or observers) listening to the observables

- a set of methods for modifying and composing the data

An observable emits items; a subscriber consumes those items

<h2>Observables</h2>
Observables are the sources for the data, they start providing data once a subscriber starts listening. An observable may emit any number of items. It can terminate either successfully or with an error. Sources may never terminate, for example, an observable for a button click can potentially produce an infinite stream of events.

<h2>Subscribers</h2>
A observable can have any number of subscribers. If a new item is emitted from the observable, the onNext() method is called on each subscriber. If the observable finishes its data flow successful, the onComplete() method is called on each subscriber. Similar, if the observable finishes its data flow with an error, the onError() method is called on each subscriber.


![architecture_diagram](https://github.com/ernancythakkar/RxJavaDemo/blob/main/screenshots/rxjava.png)
