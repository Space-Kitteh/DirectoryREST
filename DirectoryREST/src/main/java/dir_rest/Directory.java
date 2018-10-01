package main.java.dir_rest;

public class Directory extends DirectoryItem {
	
	private final DirectoryItem[] subDirectories;

	public Directory(String name, String path, long size, long lastModifiedTime, long lastAccessTime, long creationTime, boolean isSymbolicLink, DirectoryItem[] subDirectories) {
		super(name, path, size, lastModifiedTime, lastAccessTime, creationTime, isSymbolicLink);
		this.subDirectories = subDirectories;
	}
	
	public DirectoryItem[] getSubDirectories() {
		return subDirectories;
	}
}
