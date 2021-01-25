abstract class Menu {
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

	public void print() {
		String itemFormat = "| %-30s |%n";
		
		System.out.format("+--------------------------------+%n");
		System.out.format(itemFormat, title);
		System.out.format("+--------------------------------+%n");
		
		for(String option : options) {
			System.out.format(itemFormat, option);
		}
		
		System.out.format("+--------------------------------+%n\n");
	}
}
