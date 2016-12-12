// IRemoteService.aidl
package cn.iterlog.myapplication.component.service;
// 只有这样，IMyAidl.aidl才能知道其中的Person是使用了Parcelable接口的类，
// 注意，Person类的包名与Person.aidl的包名一定要相同，即无论其他应用或者其他模块，
// 只要有AIDL，都应该保证AIDL的所有包结构一致，才能保证顺利进行IPC通讯，减少不必要的麻烦。

parcelable Person;