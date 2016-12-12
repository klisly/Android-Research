package cn.iterlog.myapplication.component.service;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.ArrayList;
import java.util.List;

public class Person implements Parcelable {
    private String name;
    private int age;
    private int number;

    public Person(Parcel source) {
        this.name=source.readString();
        this.age=source.readInt();
        this.number=source.readInt();
    }

    //getter、setter method
    //...
    public Person(int age, String name, int number) {
        this.age = age;
        this.name = name;
        this.number = number;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(name);
        dest.writeInt(age);
        dest.writeInt(number);
    }
    public static final Parcelable.Creator<Person> CREATOR=new Creator<Person>() {
        @Override
        public Person createFromParcel(Parcel source) {
            return new Person(source);
        }

        @Override
        public Person[] newArray(int size) {
            return new Person[size];
        }
    };

    public static List<Person> mockPersons(){
        List<Person> persons = new ArrayList<>();
        for(int i = 0; i< 10; i++){
            Person person = new Person(i, "person"+i, i);
            persons.add(person);
        }
        return persons;
    }

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("Person{");
        sb.append("name='").append(name).append('\'');
        sb.append(", age=").append(age);
        sb.append(", number=").append(number);
        sb.append('}');
        return sb.toString();
    }
}