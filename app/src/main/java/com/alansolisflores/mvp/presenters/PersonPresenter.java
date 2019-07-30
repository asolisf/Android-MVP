package com.alansolisflores.mvp.presenters;

import com.alansolisflores.mvp.Contracts.PersonContract;
import com.alansolisflores.mvp.helpers.Constants;
import com.alansolisflores.mvp.models.Person;
import java.util.ArrayList;
import java.util.List;

public class PersonPresenter implements PersonContract.Presenter {

    private List<Person> people;

    private PersonContract.View view;

    public PersonPresenter(PersonContract.View activity){
        this.view = activity;
        people = new ArrayList<Person>();
        getTotalMessage();
    }

    private void getTotalMessage(){
        view.ShowTotal(String.format(Constants.PERSONS_ADDED_FORMAT,people.size()));
    }

    @Override
    public void AddPerson(String firstName, String lastName) {
        if(!firstName.trim().isEmpty() && !lastName.trim().isEmpty())
        {
            Person person = new Person(firstName,lastName);
            people.add(person);
            view.ShowMessage(String.format(Constants.ADD_FORMAT,person.getName()));
            getTotalMessage();
        }else{
            view.ShowMessage(Constants.ERROR_MESSAGE);
        }
    }
}
