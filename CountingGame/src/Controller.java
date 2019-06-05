public class Controller {
	
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
        	startDetailGame(players, words, answer, mode);
        } else  {
            view.outputFastCountRules();
            startFastGame(players, words, answer, mode);
        }
    }

////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////--- Main Controller Methods ---////////////////////////////////////////////////////////////////////
////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////	
	
////////////  fast game  /////////////	
	
	void startFastGame(Players players, Words words, Answers answer, Mode mode) {
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

////////////  detail game settings  /////////////		
	
	void startDetailGame(Players players, Words words, Answers answer, Mode mode) {
		setPlayerNames(players, words, answer, mode);
		setCounting(players, words, answer, mode);
	}
	
	void setPlayerNames(Players players, Words words, Answers answer, Mode mode) {
		view.outputEnterName(modelLayer.getNumberOfPlayer(players));
		modelLayer.setSomeString(words, modelLayer.inputAnyString(words));
		checkStringIsReal(words, answer);
		modelLayer.increaseNumberOfPlayer(players);
		if (modelLayer.getNumberOfPlayer(players) == 2) {
			modelLayer.increaseArrayNumber(players);
			modelLayer.addToPlayersList(players, modelLayer.getSomeString(words));
			startDetailGame(players, words, answer, mode);
		} else if (modelLayer.getNumberOfPlayer(players) > 2) {
			modelLayer.addToPlayersList(players, modelLayer.getSomeString(words));
			askMorePlayers(players, words, answer, mode);
		}
		view.outputEnterCounting();
    }		
	void setCounting(Players players, Words words, Answers answer, Mode mode) {
		modelLayer.setSomeString(words, modelLayer.inputAnyString(words));
        if (modelLayer.getSomeString(words).matches("[0-9]+")) {
        	modelLayer.setWordsNumber(words, modelLayer.getNumberFromSomeString(words, modelLayer.getSomeString(words)));
        } else {
        	countNumberOfWords(players, words, answer, mode);
        }
    	view.outputConditions(modelLayer.getPlayersList(players), modelLayer.getArrayNumber(players), modelLayer.getWordsNumber(words));
    	startDetailGameCount(players, words, answer, mode);
	}

/////////////  detail game count  ///////////////		
	
	void startDetailGameCount(Players players, Words words, Answers answer, Mode mode) {
		Calculate calculate = new Calculate();
		chooseMode(players, words, answer, calculate, mode); 
		calculation(players, words, answer, calculate, mode);
		results(players, words, answer, mode);
	    
	}
	
	void chooseMode(Players players, Words words, Answers answer, Calculate calculate, Mode mode) {
		modelLayer.copySettings(players);
	    view.outputChooseGameMode();
	    modelLayer.setSomeString(words, modelLayer.inputAnyString(words));
	    switch (modelLayer.getSomeString(words)) {
        case ("1"):
            break;
        case ("2"):
        	modelLayer.increaseCountOrder(calculate);   	
            break;
        case ("3"):
        	userRules(players, words, answer, calculate, mode);
            break;
/*
        case ("4"):
        	modelLayer.setCountOrder(calculate, modelLayer.getSomeString(words));
        	newRules(players, words, answer, calculate, mode);
            break;
*/
        default:
            view.outputIncorrectChoose();
            startDetailGameCount(players, words, answer, mode);
            break;
	    }	
	}	
	void calculation(Players players, Words words, Answers answer, Calculate calculate, Mode mode) {
	    switch (modelLayer.getSomeString(words)) {
        case ("1"):
        	calculate(players, words, answer, calculate, mode);
            break;
        case ("2"):  	
        	calculate(players, words, answer, calculate, mode);
            break;
        case ("3"):
        	calculate(players, words, answer, calculate, mode);
            break;
        case ("4"):
        	calculate(players, words, answer, calculate, mode);
            break; 
	    }	
	}		
	void results(Players players, Words words, Answers answer, Mode mode) {
		view.outputResult(modelLayer.getPlayersList(players), modelLayer.getArrayNumber(players));
	    view.outputPlayAgain();
        playAgain(players, words, answer, mode);
	}	
           
////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////--- Additional Controller Methods ---//////////////////////////////////////////////////////////////
////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

///////////////  players
	
	void askMorePlayers(Players players, Words words, Answers answer, Mode mode) {
		view.outputMorePlayers();
		modelLayer.setAnswer(answer, modelLayer.inputAnyString(words));
		if (!(checkAnswer(words, answer))) {
			modelLayer.resetNumberOfPlayer(players);
        } else {
        	modelLayer.increaseArrayNumber(players);
        	startDetailGame(players, words, answer, mode);
        }
	}

///////////////  words
	
	void countNumberOfWords(Players players, Words words, Answers answer, Mode mode) {
		modelLayer.resetWordsNumber(words);
		testForSeveralWords(words);
    	checkNumberOfWords(players, words, answer, mode);
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
	void checkNumberOfWords(Players players, Words words, Answers answer, Mode mode) {
    	view.outputCountCheck(modelLayer.getSomeNumber(words));
        modelLayer.setAnswer(answer, modelLayer.inputAnyString(words));
        if (!(checkAnswer(words, answer))) {
        	checkNumberOfWordsAgain(players, words, answer, mode);
        	modelLayer.setWordsNumber(words, modelLayer.getSomeNumber(words) - 1);
        } else {
        	modelLayer.setWordsNumber(words, modelLayer.getSomeNumber(words));
        }
    }    
    void checkNumberOfWordsAgain(Players players, Words words, Answers answer, Mode mode) {
    	view.outputCountCheckAgain(modelLayer.getSomeNumber(words));
    	modelLayer.setAnswer(answer, modelLayer.inputAnyString(words));
        if (!(checkAnswer(words, answer))) {
            view.outputEnterCountingAgain();
    		setCounting(players, words, answer, mode);
        } else {
        }
    }
        
///////////////  calculations

    void userRules(Players players, Words words, Answers answer, Calculate calculate, Mode mode) {
        view.outputSetCountStartNumber();
        checkStringIsOnlyNumber(words);
        modelLayer.setStartNumber(calculate, modelLayer.getNumberFromSomeString(words, modelLayer.getSomeString(words)));
        
        view.outputSetCountStepNumber();
        checkStringIsOnlyNumber(words);
        modelLayer.setStepNumber(calculate, modelLayer.getNumberFromSomeString(words, modelLayer.getSomeString(words)));
        
        view.outputSetCountOrder();        
        modelLayer.setSomeString(words, modelLayer.inputAnyString(words));
        while (!(modelLayer.getSomeString(words).equals("1") || modelLayer.getSomeString(words).equals("2"))) {
        	view.outputIncorrectChoose();
        	modelLayer.setSomeString(words, modelLayer.inputAnyString(words));
        }
        modelLayer.setCountOrder(calculate, modelLayer.getSomeString(words));
        calculation(players, words, answer, calculate, mode);
        
    }   
	void newRules(Players players, Words words, Answers answer, Calculate calculate, Mode mode) {
		calculation(players, words, answer, calculate, mode);
	}
	
	void calculate(Players players, Words words, Answers answer, Calculate calculate, Mode mode) {
    	view.outputstartCounting(modelLayer.getStartNumber(calculate), modelLayer.getStepNumber(calculate));
        view.outputAllPlayers(modelLayer.getPlayersList(players), modelLayer.getArrayNumber(players), modelLayer.getWordsNumber(words));
        modelLayer.resetNumStep(calculate);
        modelLayer.setFinalNumber(calculate, modelLayer.getWordsNumber(words)*modelLayer.getStepNumber(calculate) - modelLayer.getStepNumber(calculate) + modelLayer.getStartNumber(calculate));
        while(modelLayer.getArrayNumber(players) > 1) {
        	if (modelLayer.getNumberFromSomeString(words, modelLayer.getCountOrder(calculate)) < 3) {
            	modelLayer.mainCalc(players, calculate, modelLayer.getPlayersList(players), modelLayer.getArrayNumber(players), modelLayer.getWordsNumber(words));
        	} else {
        		modelLayer.newCalc(players, calculate, modelLayer.getPlayersList(players), modelLayer.getArrayNumber(players), modelLayer.getWordsNumber(words));
        	} 
        	modelLayer.reduceArrayNumber(players);
        	view.outputTempResult(modelLayer.getPlayersList(players), modelLayer.getArrayNumber(players), modelLayer.getNumStep(calculate), modelLayer.getOutPlayer(calculate));
        	modelLayer.increaseNumStep(calculate);
        }        
        results(players, words, answer, mode);
        modelLayer.resetCountOrder(calculate);
	}

///////////////  play again
	
	void playAgain(Players players, Words words, Answers answer, Mode mode) {
    	modelLayer.setAnswer(answer, modelLayer.inputAnyString(words));
        if (!(checkAnswer(words, answer))) {
            view.outputFinal();
            System.exit(0);
        } else {
            if(modelLayer.getPlayMode(mode).equals("2")) {
                view.outputChooseContinue();
                continueSettings(players, words, answer, mode);
            } else  {
            	execute();
            }
        }
    }      
    void continueSettings(Players players, Words words, Answers answer, Mode mode) {
    	Mode continueMode = new Mode();
        modelLayer.setContinueMode(continueMode, modelLayer.inputAnyString(words));
        switch (modelLayer.getContinueMode(continueMode)) {
            case ("1"):
            	view.outputAgainFromBegin();
            	execute();
                break;
            case ("2"):
            	modelLayer.returnSettings(players);
            	view.outputAgainWithMyTeam();
        		view.outputEnterCounting();
            	setCounting(players, words, answer, mode);
                break;
            case ("3"):
            	modelLayer.returnSettings(players);
            	view.outputConditions(modelLayer.getPlayersList(players), modelLayer.getArrayNumber(players), modelLayer.getWordsNumber(words));
            	startDetailGameCount(players, words, answer, mode);
                break;
            default:
                view.outputIncorrectChoose();
                continueSettings(players, words, answer, mode);
        }
    }	
	
////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////--- Service Controller Methods ---/////////////////////////////////////////////////////////////////
////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	
    public boolean checkAnswer(Words words, Answers answer) {
    	checkStringIsReal(words, answer);
        if (!(checkAnswerIsPositive(words, answer))) {
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
        	if (additionalCheckOfAnswer(words, answer)) {
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
    	checkAnswerChoice(words, answer);
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
