package com.api.gamelist.dto;

public class ReplacementDTO {
	
	private Integer sourceIndex;
	private Integer destinationIndex;
	
	public ReplacementDTO() {
		
	}
	
	public ReplacementDTO(int sourceIndex, int destinationIndex) {
		this.sourceIndex = sourceIndex;
		this.destinationIndex = destinationIndex;
	}

	public int getSourceIndex() {
		return sourceIndex;
	}

	public void setSourceIndex(int sourceIndex) {
		this.sourceIndex = sourceIndex;
	}

	public int getDestinationIndex() {
		return destinationIndex;
	}

	public void setDestinationIndex(int destinationIndex) {
		this.destinationIndex = destinationIndex;
	}
}
