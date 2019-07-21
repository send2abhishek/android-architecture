package com.techyourchance.mvc.screens.questionslist;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.techyourchance.mvc.R;
import com.techyourchance.mvc.questions.Question;

import java.util.ArrayList;
import java.util.List;

public class QuestionsListItemViewMvcImpl implements QuestionListItemViewMvc{

    private View rootView;
    private TextView txtTitle;
    private List<Listener> mlisteners=new ArrayList<>(1);
    private Question mquestion;

    public QuestionsListItemViewMvcImpl(LayoutInflater inflater, ViewGroup parent) {

        rootView=inflater.inflate(R.layout.layout_question_list_item,parent,false);
        txtTitle =findViewById(R.id.txt_title);
        getRootView().setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                for(Listener listener:mlisteners){

                    listener.onQuestionClicked(mquestion);
                }
            }
        });

    }

    private <T extends View> T findViewById(int id) {

        return getRootView().findViewById(id);
    }


    @Override
    public void registerListener(Listener listener) {
        mlisteners.add(listener);
    }

    @Override
    public void unRegisterListener(Listener listener) {

        mlisteners.remove(listener);
    }



    @Override
    public View getRootView() {
        return rootView;
    }

    @Override
    public void QuestionsBind(Question questions) {
        mquestion=questions;
        txtTitle.setText(questions.getTitle());
    }


}
