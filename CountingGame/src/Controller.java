public class Controller {
	
	private static Controller controller = new Controller();
	private static ModelLayer modelLayer = new InputLayer();
	private static View view = new ConsoleView();
	
	void execute() {
		Players players = new Players();
        Words words = new Words();
        Answers answer = new Answers();
        Mode mode = new Mode();
        chooseTheGame(players, words, answer, mode);
	}
	
	void chooseTheGame(Players players, Words words, Answers answer, Mode mode) {
		view.outputStart();
        modelLayer.setPlayMode(mode, modelLayer.inputAnyString(words));
        if(!(modelLayer.getPlayMode(mode).equals("1") || modelLayer.getPlayMode(mode).equals("2"))) {
        	view.outputIncorrectChoose();
            execute();
        } else if (modelLayer.getPlayMode(mode).equals("2")) {
        	view.outputGreetings();
            startDetailCount(players, words, answer, mode);
        } else  {
            view.outputFastCountRules();
            startFastCount(players, words, answer, mode);
        }
    }
	
	void startFastCount(Players players, Words words, Answers answer, Mode mode) {
		Calculate calculate = new Calculate();
		setNumberOfPlayers(players, words);
		setNumberOfWords(players, words);
		fastCalculation(players, words, calculate, answer, mode);       
    }
		
	void setNumberOfPlayers(Players players, Words words) {
		view.outputEnterPlayersFastCount();
        checkStringIsOnlyNumber(words); 
        modelLayer.setArrayNumber(players, modelLayer.getNumberFromSomeString(words, modelLayer.getSomeString(words)));
    }	
	void setNumberOfWords(Players players, Words words) {
		view.outputEnterCountingFastCount();
        checkStringIsOnlyNumber(words);
        modelLayer.setWordsNumber(words, modelLayer.getNumberFromSomeString(words, modelLayer.getSomeString(words)));
    }	
	void fastCalculation(Players players, Words words, Calculate calculate, Answers answer, Mode mode) {
		modelLayer.numberingOfPlayers(players, modelLayer.getArrayNumber(players));
        modelLayer.fastCalc(calculate, modelLayer.getFastCountPlayersList(players), modelLayer.getArrayNumber(players), modelLayer.getWordsNumber(words));
        view.outputResultFastCount(modelLayer.getFastCountPlayersList(players));
        view.outputPlayAgain();
        playAgain(players, words, answer, mode);
    }	

	void startDetailCount(Players players, Words words, Answers answer, Mode mode) {
		setPlayerNames(players, words, answer, mode);
	}
	
	void setPlayerNames(Players players, Words words, Answers answer, Mode mode) {
		view.outputEnterName(modelLayer.getNumberOfPlayer(players));
		modelLayer.setSomeString(words, modelLayer.inputAnyString(words));
		controller.checkStringIsReal(words, answer);
		modelLayer.increaseNumberOfPlayer(players);
		if (modelLayer.getNumberOfPlayer(players) == 2) {
			modelLayer.increaseArrayNumber(players);
			modelLayer.addToPlayersList(players, modelLayer.getSomeString(words));
			startDetailCount(players, words, answer, mode);
		} else if (modelLayer.getNumberOfPlayer(players) > 2) {
			modelLayer.addToPlayersList(players, modelLayer.getSomeString(words));
			askMorePlayers(players, words, answer, mode);
		}
		controller.startWithMyPlayers(players, words, answer, mode);
    }	
	
	void startWithMyPlayers(Players players, Words words, Answers answer, Mode mode) {
		view.outputEnterCounting();
		while(!(modelLayer.finishCount(words))) {
			modelLayer.setSomeString(words, modelLayer.inputAnyString(words));
	        if (modelLayer.getSomeString(words).matches("[0-9]+")) {
	        	modelLayer.increaseCountIndex(words);
	        	modelLayer.setWordsNumber(words, modelLayer.getNumberFromSomeString(words, modelLayer.getSomeString(words)));
	        } else {
	        	controller.countNumberOfWords(words, answer);
	        }
		}
		modelLayer.resetCountIndex(words);
    	view.outputConditions(modelLayer.getPlayersList(players), modelLayer.getArrayNumber(players), modelLayer.getWordsNumber(words));
		controller.startWithMyConditions(players, words, answer, mode);
	}
	
	void startWithMyConditions(Players players, Words words, Answers answer, Mode mode) {
		modelLayer.copySettings(players);
		Calculate calculate = new Calculate();
	    view.outputChooseGameMode();
	    modelLayer.setSomeString(words, modelLayer.inputAnyString(words));
	    switch (modelLayer.getSomeString(words)) {
        case ("1"):
        	controller.calculate(players, words, answer, calculate, mode);
            break;
        case ("2"):
        	modelLayer.increaseGameOrder(calculate);   	
        	controller.calculate(players, words, answer, calculate, mode);
            break;
        case ("3"):
        	controller.inputUserGameMode(players, words, answer, calculate, mode);
            break;
//        case ("4"):
//        	controller.newRules(players, words, answer, calculate, mode);
//            break;
        default:
            view.outputIncorrectChoose();
            controller.startWithMyConditions(players, words, answer, mode);
            break;
	    }	    
	    view.outputResult(modelLayer.getPlayersList(players), modelLayer.getArrayNumber(players));
	    view.outputPlayAgain();
        playAgain(players, words, answer, mode);
	}
		
    void playAgain(Players players, Words words, Answers answer, Mode mode) {
    	modelLayer.setAnswer(answer, modelLayer.inputAnyString(words));
        if (!(controller.checkAnswer(words, answer))) {
            view.outputFinal();
            System.exit(0);
        } else {
            if(modelLayer.getPlayMode(mode).equals("2")) {
                view.outputChooseContinue();
                continueSettings(players, words, answer, mode);
            } else  {
            	controller.execute();
            }
        }
    }
      
    void continueSettings(Players players, Words words, Answers answer, Mode mode) {
    	Mode continueMode = new Mode();
        modelLayer.setContinueMode(continueMode, modelLayer.inputAnyString(words));
        switch (modelLayer.getContinueMode(continueMode)) {
            case ("1"):
            	view.outputAgainFromBegin();
            	controller.execute();
                break;
            case ("2"):
            	modelLayer.returnSettings(players);
            	view.outputAgainWithMyTeam();
            	controller.startWithMyPlayers(players, words, answer, mode);
                break;
            case ("3"):
            	modelLayer.returnSettings(players);
            	view.outputConditions(modelLayer.getPlayersList(players), modelLayer.getArrayNumber(players), modelLayer.getWordsNumber(words));
            	controller.startWithMyConditions(players, words, answer, mode);
                break;
            default:
                view.outputIncorrectChoose();
                controller.continueSettings(players, words, answer, mode);
        }
    }
   
    
//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	
	

	void askMorePlayers(Players players, Words words, Answers answer, Mode mode) {
		view.outputMorePlayers();
		modelLayer.setAnswer(answer, modelLayer.inputAnyString(words));
		if (!(controller.checkAnswer(words, answer))) {
			modelLayer.resetNumberOfPlayer(players);
        } else {
        	modelLayer.increaseArrayNumber(players);
        	startDetailCount(players, words, answer, mode);
        }
	}
	
	void countNumberOfWords(Words words, Answers answer) {
		modelLayer.resetWordsNumber(words);
		controller.testForSeveralWords(words);
    	controller.checkNumberOfWords(words, answer);
    }
    
	void testForSeveralWords(Words words) {
		modelLayer.setSomeNumber(words, modelLayer.countWordsFromString(words, modelLayer.getSomeString(words)));
        while (modelLayer.getSomeNumber(words) < 2) {
            view.outputWhat();
            modelLayer.setSomeString(words, modelLayer.inputAnyString(words));
            if (modelLayer.getSomeString(words).matches("[0-9]+")) {
            	modelLayer.setSomeNumber(words, modelLayer.getNumberFromSomeString(words, modelLayer.getSomeString(words)));
            } else {
            	modelLayer.setSomeNumber(words, modelLayer.countWordsFromString(words, modelLayer.getSomeString(words)));
            }
        }
    }
	
	void checkNumberOfWords(Words words, Answers answer) {
    	view.outputCountCheck(modelLayer.getSomeNumber(words));
        modelLayer.setAnswer(answer, modelLayer.inputAnyString(words));
        if (!(controller.checkAnswer(words, answer))) {
        	checkNumberOfWordsAgain(words, answer);
        	modelLayer.setWordsNumber(words, modelLayer.getSomeNumber(words) - 1);
        } else {
        	modelLayer.increaseCountIndex(words);
        	modelLayer.setWordsNumber(words, modelLayer.getSomeNumber(words));
        }
    }
    
    void checkNumberOfWordsAgain(Words words, Answers answer) {
    	view.outputCountCheckAgain(modelLayer.getSomeNumber(words));
    	modelLayer.setAnswer(answer, modelLayer.inputAnyString(words));
        if (!(controller.checkAnswer(words, answer))) {
            view.outputEnterCountingAgain();
        } else {
        	modelLayer.increaseCountIndex(words);
        }
    }
    
    
////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

    void inputUserGameMode(Players players, Words words, Answers answer, Calculate calculate, Mode mode) {
        view.outputEnterUserSettings();
        controller.checkStringIsOnlyNumber(words);
        modelLayer.setStartNumber(calculate, modelLayer.getNumberFromSomeString(words, modelLayer.getSomeString(words)));
        
        view.outputEnterUserSettingsStep();
        controller.checkStringIsOnlyNumber(words);
        modelLayer.setStepNumber(calculate, modelLayer.getNumberFromSomeString(words, modelLayer.getSomeString(words)));
        
        view.outputEnterUserGameMode();
        
        modelLayer.setSomeString(words, modelLayer.inputAnyString(words));
        while (!(modelLayer.getSomeString(words).equals("1") || modelLayer.getSomeString(words).equals("2"))) {
        	view.outputIncorrectChoose();
        	modelLayer.setSomeString(words, modelLayer.inputAnyString(words));
        }
        modelLayer.setGameOrder(calculate, modelLayer.getSomeString(words));
        controller.calculate(players, words, answer, calculate, mode);
        
    }
	
	void calculate(Players players, Words words, Answers answer, Calculate calculate, Mode mode) {
    	view.outputstartCounting();
        view.outputAllPlayers(modelLayer.getPlayersList(players), modelLayer.getArrayNumber(players));
        modelLayer.setFinalNumber(calculate, modelLayer.getWordsNumber(words)*modelLayer.getStepNumber(calculate) - (modelLayer.getStepNumber(calculate) - 1) + (modelLayer.getStartNumber(calculate) - 1));
        modelLayer.resetNumStep(calculate);
        while(modelLayer.getArrayNumber(players) > 1) {
        	modelLayer.mainCalc(calculate, modelLayer.getPlayersList(players), modelLayer.getArrayNumber(players), modelLayer.getWordsNumber(words), modelLayer.getGameOrder(calculate));
        	modelLayer.reduceArrayNumber(players);
        	view.outputTempResult(modelLayer.getPlayersList(players), modelLayer.getArrayNumber(players), modelLayer.getNumStep(calculate), modelLayer.getOutPlayer(calculate));
        	modelLayer.increaseNumStep(calculate);
        }
	}
       
	void newRules(Players players, Words words, Answers answer, Calculate calculate, Mode mode) {
		modelLayer.newCalc(calculate, modelLayer.getPlayersList(players), modelLayer.getArrayNumber(players), modelLayer.getWordsNumber(words));
	}

	
	
///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	
    public boolean checkAnswer(Words words, Answers answer) {
    	controller.checkStringIsReal(words, answer);
        if (!(controller.checkAnswerIsPositive(words, answer))) {
        	return false;
        }
        return true;
    }
    
    public void checkStringIsReal(Words words, Answers answer) {
    	while (!(modelLayer.checkStringIsReal(words, modelLayer.getSomeString(words)))) {
        	view.outputWhat();
        	modelLayer.setSomeString(words, modelLayer.inputAnyString(words));
        }
    }
    
    public boolean checkAnswerIsPositive(Words words, Answers answer) {
        if (!(modelLayer.checkPositiveOrNegativeAnswer(answer)))  {
        	view.outputIncorrectAnswer();
        	modelLayer.setConfirmationAnswer(answer, modelLayer.inputAnyString(words));
        	if (controller.additionalCheckOfAnswer(words, answer)) {
                return true;
        	} else {
        		return false; 
        	}
        } else if (modelLayer.checkNegativeAnswer(answer)) {
            return false;
        }
        return true;
    }
    
    public boolean additionalCheckOfAnswer(Words words, Answers answer) {
    	controller.checkAnswerChoice(words, answer);
        if (modelLayer.getConfirmationAnswer(answer).equals("1")) {
        	modelLayer.addToPositiveAnswerList(answer);
            return true;
        } else {
        	modelLayer.addToNegativeAnswerList(answer);
            return false;
        }
    }
    
    public void checkAnswerChoice(Words words, Answers answer) {
        while (!(modelLayer.getConfirmationAnswer(answer).equals("1") || (modelLayer.getConfirmationAnswer(answer).equals("2")))) {
            view.outputIncorrectAnswer();
            view.outputIncorrectChoose();
        	modelLayer.setConfirmationAnswer(answer, modelLayer.inputAnyString(words));
        }
    } 
    
    public void checkStringIsOnlyNumber(Words words) {
    	modelLayer.setSomeString(words, modelLayer.inputAnyString(words));
        while(!(modelLayer.checkStringIsOnlyNumber(words, modelLayer.getSomeString(words)))) {
  	      view.outputCheckedNumber();
  	      modelLayer.setSomeString(words, modelLayer.inputAnyString(words));
        }       
    } 
    
    
}
