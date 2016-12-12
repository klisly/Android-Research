// IRemoteService.aidl
package cn.iterlog.myapplication.component.service;

// Declare any non-default types here with import statements
import cn.iterlog.myapplication.component.service.Person;
//AIDL中除了基本数据类型，其他类型的参数必须标上方向，in、out、或者inout，
//in表示输入型参数，out表示输出型参数，inout表示输入输出型参数，
//我们要根据需要实际指定参数类型，因为底层的数据处理开销非常大，
//如果不指定类型，编译将会无法通过。
//①基本数据类型(int,long,char,boolean,double)
  //②string和CharSequence
 // ③List：只支持ArrayList，以及里面所有的元素必须能够被AIDL支持 ④Map:只支持HashMap，以及里面所有的元素必须能够被AIDL支持 ⑤Parcelable：所有实现了Parcelable接口的对象
 // ⑥AIDL：所有AIDL接口本身也可以在AIDL文件中使用。
 // 如果使用了自定义的对象，那么需要定义该对象的aidl
interface IRemoteService {
    /**
     * Demonstrates some basic types that you can use as parameters
     * and return values in AIDL.
     */
    void basicTypes(int anInt, long aLong, boolean aBoolean, float aFloat,
            double aDouble, String aString);
    void addPerson(in Person person);
    List<Person> getPersons();
    void stop();

    void buildDialog();
}
