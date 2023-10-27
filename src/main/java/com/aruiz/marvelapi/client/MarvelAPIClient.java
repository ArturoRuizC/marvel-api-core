package com.openpay.marvelapi.client;

import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;
import com.openpay.marvelapi.util.Const;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;

public class MarvelAPIClient {

	@Autowired
	private RestTemplate restTemplate;

	@Value("${marvel.api.urlprincipal}")
	private String url;

	@Value("${marvel.api.apikey}")
	private String apikey;

	@Value("${marvel.api.hash}")
	private String hash;

	public Object getCharacters() {
		UriComponentsBuilder builder = 	UriComponentsBuilder.fromOriginHeader(url)
				.queryParam(Const.TS_LABEL, Const.UNO)
				.queryParam(Const.APIKEY_LABEL, apikey)
				.queryParam(Const.HASH_LABEL, hash);
		String endpoitn = builder.toUriString();
		Object response = restTemplate.getForObject(endpoitn, Object.class);
		return response;
	}

	public Object getCharacterById(Integer idCharacter) {
		UriComponentsBuilder builder = 	UriComponentsBuilder.fromOriginHeader(url + Const.SLASH + idCharacter)
				.queryParam(Const.TS_LABEL, Const.UNO)
				.queryParam(Const.APIKEY_LABEL, apikey)
				.queryParam(Const.HASH_LABEL, hash);
		String endpoitn = builder.toUriString();
		Object response = restTemplate.getForObject(endpoitn, Object.class);
		return response;
	}
}