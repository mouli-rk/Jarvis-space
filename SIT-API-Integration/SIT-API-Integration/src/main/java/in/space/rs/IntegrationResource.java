package in.space.rs;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import in.space.model.JsonPlaceHolder;
import in.space.common.ERPConstant;
import in.space.service.IntegrationService;

@RestController
@RequestMapping(value = ERPConstant.API_VERSION_ONE)
public class IntegrationResource {
				
	@Autowired
	private IntegrationService integrationService;
	
	@GetMapping(value = ERPConstant.JSON_PLACE_GET)
	public List<JsonPlaceHolder> jsonPlaceHolderGET(){
		return integrationService.jsonPlaceHolderGET();
	}
 
}
