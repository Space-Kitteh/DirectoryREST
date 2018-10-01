package com.dir_rest;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.ArrayList;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MessageController {

	@RequestMapping("/info")
	public DirectoryItem info(@RequestParam(value = "directoryPath", defaultValue = "") String directoryPath) {

		File directory = new File(directoryPath);

		Path dirPath = directory.toPath();
		
		try {
			BasicFileAttributes attr = Files.readAttributes(dirPath, BasicFileAttributes.class);
			
			if (attr.isDirectory())	{

			return new Directory(
					directory.getName(), 
					directory.getAbsolutePath(), 
					attr.size(),
					attr.lastModifiedTime().toMillis(), 
					attr.lastAccessTime().toMillis(),
					attr.creationTime().toMillis(), 
					attr.isSymbolicLink(), 
					getFilesAndSubdirs(directory));
			}
			else
			{
				return new DirectoryItem(
						directory.getName(), 
						directory.getAbsolutePath(), 
						attr.size(),
						attr.lastModifiedTime().toMillis(), 
						attr.lastAccessTime().toMillis(),
						attr.creationTime().toMillis(), 
						attr.isSymbolicLink());
			}

		} catch (IOException e) {
			throw new RuntimeException(e);
		}

	}

	public DirectoryItem[] getFilesAndSubdirs(File dir) throws IOException {
		DirectoryItem[] items = new DirectoryItem[0];
		File[] fList = dir.listFiles();
		ArrayList<DirectoryItem> files = new ArrayList<DirectoryItem>();
		if (fList != null) {
			for (File file : fList) {
				Path dirPath = file.toPath();
				BasicFileAttributes attr = Files.readAttributes(dirPath, BasicFileAttributes.class);
				
				if (attr.isDirectory()) {
					files.add( new Directory(
							file.getName(), 
							file.getAbsolutePath(), 
							attr.size(),
							attr.lastModifiedTime().toMillis(), 
							attr.lastAccessTime().toMillis(),
							attr.creationTime().toMillis(), 
							attr.isSymbolicLink(), 
							getFilesAndSubdirs(file))
					);
				}
				else {
					files.add( new DirectoryItem(
							file.getName(), 
							file.getAbsolutePath(), 
							attr.size(),
							attr.lastModifiedTime().toMillis(), 
							attr.lastAccessTime().toMillis(),
							attr.creationTime().toMillis(), 
							attr.isSymbolicLink())
					);
				}
			}
		}
		
		return files.toArray(items);

	}
}