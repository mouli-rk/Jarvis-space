package in.space.service.impl;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

import org.hibernate.engine.jdbc.dialect.spi.DatabaseMetaDataDialectResolutionInfoAdapter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import in.space.model.JsonPlaceHolder;
import in.space.service.IntegrationService;

@Service
public class IntegrateServiceImpl implements IntegrationService{
	
	private static final String URL="https://jsonplaceholder.typicode.com";
	
	private static final String PARAM="/posts";
	
	@Autowired
	private RestTemplate restTemplate;
	
	ObjectMapper objectMapper = new ObjectMapper();


	public List<JsonPlaceHolder> jsonPlaceHolderGET() {
		HttpEntity<Void> httpEntity = new HttpEntity<>(getHttpHeaders());
		ResponseEntity<String> response = restTemplate.exchange(URL + PARAM, HttpMethod.GET, httpEntity, String.class);

		List<JsonPlaceHolder> jsonList;
		try {
			jsonList = objectMapper.readValue(response.getBody(), new TypeReference<List<JsonPlaceHolder>>() {});
		} catch (Exception e) {
			throw new RuntimeException("Failed to deserialize JSON response", e);
		}

		return jsonList;
	}
	
	private HttpHeaders getHttpHeaders() {
		HttpHeaders headers = new HttpHeaders();
		headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
		headers.setContentType(MediaType.APPLICATION_JSON);
		return headers;
	}
	

}
