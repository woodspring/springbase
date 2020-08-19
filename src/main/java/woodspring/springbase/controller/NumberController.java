package woodspring.springbase.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import woodspring.springbase.service.NumberService;

@RestController
@RequestMapping(value="springbase")
public class NumberController {
	private final static Logger logger = LoggerFactory.getLogger(NumberController.class);
	@Autowired
	@Qualifier("NumberServiceImpl")
	private NumberService munberSrvImpl;
	
	@Autowired
	@Qualifier("NumberH2Service")
	private NumberService numberH2Srv;
	
	@GetMapping("/test")
	public String testStart() {
		return "CONNECTED";
	}
	
	@GetMapping("/store")
	public int storeNumber(@RequestParam("number") String number) {
		int retI = munberSrvImpl.storeNumbere( number);
		logger.info("storeNumber, number:{}, ret:{}", number, retI);
		return retI;
		
	}
	
	@GetMapping("/number")
	public List<Integer> getNumber(@RequestParam("numIndex")int numIndex) {
		List<Integer> retList = munberSrvImpl.getNumber( numIndex);
		logger.info("getNumber:{}, list:{}", numIndex, retList);
		return retList;		
	}
	@GetMapping("/h2/store")
	public int storeNumberH2(@RequestParam("number") String number) {
		int retI = numberH2Srv.storeNumbere(number);
		logger.info("storeNumberH2, number:{}, ret:{}", number, retI);
		
		return retI;
		
	}
	
	@GetMapping("/h2/number")
	public List<Integer> getNumberH2(@RequestParam("numIndex")int numIndex) {
		List<Integer> retList = numberH2Srv.getNumber( numIndex);
		logger.info("getNumber:{}, list:{}", numIndex, retList);

		
		return retList;		
	}

}
