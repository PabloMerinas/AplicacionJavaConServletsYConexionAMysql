package main;

import bdController.BdController;

public class Main {

	public static void main(String[] args) {

		BdController.connect();
		BdController.disconnect();
	}

}
