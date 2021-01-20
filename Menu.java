public abstract class Menu {
	public String[] options;
	public String title;

	public Menu(String[] options, String title) {
		this.options = options;
		this.title = title;
	}
	
	public boolean validateOption(int option) {
		return options.length > option;
	}
	
	public abstract void processChoice(int choice);

	@Override
	public String toString() {
		String output = title + 
			"\n===========================\n";
		
		for(String option : options) {
			output += option + "\n";
		}
		
		return output;
	}
}
