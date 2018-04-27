package controller;

import java.io.IOException;

import com.pengrad.telegrambot.model.Update;

import model.Model;
import view.View;

public class AbsenceController implements ProcessController {

	private Model model;
	private View view;

	public AbsenceController(Model model, View view) {
		this.model = model;
		this.view = view;
	}

	public void process(Update update) {
		view.sendTypingMessage(update);
		try {
			model.getAbsenses(update.message().chat().id());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
