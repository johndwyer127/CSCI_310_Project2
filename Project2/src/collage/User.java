package collage;

import java.util.ArrayList;
import java.util.List;

public class User {
	public static class UserClass {
		private static List<Picture> previousCollages = new ArrayList<Picture>();
		public static Picture currentCollage = null;
		public static int numPreviousSearches = -1;
		public static List<Picture> getCollages(){
			return previousCollages;
		}
//		public static void addCollage(Picture newCollage){
//			previousCollages.add(newCollage);
//			//collages.add(newCollage.writeImage(fileName, "png"));
//		}
		public static void setCurrentCollage(Picture currCollage) {
			currentCollage = currCollage;
		}
		public static void addPreviousCollage(){
			previousCollages.add(currentCollage);
			//collages.add(newCollage.writeImage(fileName, "png"));
		}
		public static int getNumPreviousSearches() {
			// TODO Auto-generated method stub
			return numPreviousSearches;
		}
	}
	
}
