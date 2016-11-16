import java.io.File;
import java.io.FileFilter;

public class XMLfilter implements FileFilter {
	
	private final String acceptableName = "xml";
	
	@Override
	public boolean accept(File pathname) {
		if (pathname.getName().endsWith(acceptableName)){
			return true;
		}
		return false;
	}

}
