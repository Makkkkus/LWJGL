package core;

public class Version {
	
	private int make, major, minor;
	
	public Version(String version) {
		String[] nums = version.split("\\.");
		try {
			if(nums.length > 0) make = Integer.parseInt(nums[0]);
			else make = 0;
			
			if(nums.length > 1) major = Integer.parseInt(nums[1]);
			else major = 0;
			
			if(nums.length > 2) minor = Integer.parseInt(nums[2]);
			else minor = 0;
			
		} catch(NumberFormatException ex) {
			if(Game.debug) System.err.println("Invalid version number: " + version);
			return;
		} catch(Exception ex) {
			if(Game.debug) ex.printStackTrace();
			return;
		}
	}
	
	public String toString() { return make + "." + major + "." + minor; }
}
