package com.aruiz.marvelapi.model;

import java.util.List;
import lombok.Data;
import lombok.ToString;

@Data
@ToString
public class SeriesList {
	
	private int available;
	private int returned;
	private String collectionURI;
	private List<SeriesSummary> items;
}