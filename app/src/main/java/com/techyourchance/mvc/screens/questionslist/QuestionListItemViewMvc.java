package com.techyourchance.mvc.screens.questionslist;

import android.view.View;

import com.techyourchance.mvc.questions.Question;


public interface QuestionListItemViewMvc {


    interface Listener{

        void onQuestionClicked(Question question);
    }

    void registerListener(Listener listener);

    void unRegisterListener(Listener listener);

    View getRootView();

    void QuestionsBind(Question questions);
}
