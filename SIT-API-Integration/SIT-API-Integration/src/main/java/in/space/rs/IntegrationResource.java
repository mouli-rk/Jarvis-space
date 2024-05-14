package in.space.rs;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import in.space.model.JsonPlaceHolder;
import in.space.common.ERPConstant;
import in.space.service.IntegrationService;

@RestController
@RequestMapping("/api/v1")
public class IntegrationResource {
				
	@Autowired
	private IntegrationService integrationService;
	
	@GetMapping("/jsonplace/get")
	public List<JsonPlaceHolder> jsonPlaceHolderGET(){
		return integrationService.jsonPlaceHolderGET();
	}
 
}
