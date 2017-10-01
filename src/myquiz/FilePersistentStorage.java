package myquiz;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class FilePersistentStorage {

	private String fileName = "";
	
	public FilePersistentStorage(String fileName) {
		this.fileName = fileName;
	}
	
	public void store(Questions dataSource) throws FileNotFoundException, IOException {
        File f = new File(fileName);
        ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(f));
        oos.writeObject(dataSource);
        oos.flush();  // needed??? doesn't close do a flush???
        oos.close();
        System.out.println("stored to " + fileName);
	}
	public Questions retrieve() throws FileNotFoundException, IOException, ClassNotFoundException {
        File f = new File(fileName);
		ObjectInputStream iis = new ObjectInputStream(new FileInputStream(f));
		Object obj = iis.readObject();
		Questions q = (Questions)obj;
		iis.close();
		System.out.println("" + q.size() + " read from " + fileName);
		System.out.println(q);
		return q;
	}
}