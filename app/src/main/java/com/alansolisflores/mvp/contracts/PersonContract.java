package com.alansolisflores.mvp.contracts;

public interface PersonContract {

    interface View{

        void ShowMessage(String message);

        void ShowTotal(String total);
    }

    interface Presenter {

        void AddPerson(String firstName,String lastName);

    }
}
