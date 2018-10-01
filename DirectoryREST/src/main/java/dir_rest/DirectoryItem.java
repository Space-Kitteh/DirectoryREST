package main.java.dir_rest;

public class DirectoryItem {

	private final String name;
	private final String path;
	private final long size;
	private final long lastModifiedTime;
	private final long lastAccessTime;
	private final long creationTime;
	private final boolean isSymbolicLink;
	
	public DirectoryItem(String name, String path, long size, long lastModifiedTime, long lastAccessTime, long creationTime, boolean isSymbolicLink) {
		this.name = name;
		this.path = path;
		this.size = size;
		this.lastModifiedTime = lastModifiedTime;
		this.lastAccessTime = lastAccessTime;
		this.creationTime = creationTime;
		this.isSymbolicLink = isSymbolicLink;
	}

	public String getName() {
		return name;
	}
	
	public String getPath() {
		return path;
	}

	public long getSize() {
		return size;
	}

	public long getLastModifiedTime() {
		return lastModifiedTime;
	}

	public long getLastAccessTime() {
		return lastAccessTime;
	}

	public long getCreationTime() {
		return creationTime;
	}

	public boolean isSymbolicLink() {
		return isSymbolicLink;
	}
	
	
}
