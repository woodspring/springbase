package woodspring.springbase.service.impl;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.ConcurrentSkipListMap;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import woodspring.springbase.service.NumberService;

@Service
@Qualifier("NumberServiceImpl")
public class NumberServiceImpl implements NumberService {
	private final static Logger logger = LoggerFactory.getLogger(NumberServiceImpl.class);
	private ConcurrentSkipListMap<Integer, String> numberMap = new ConcurrentSkipListMap<>();
	private int size =0;

	@Override
	public int storeNumbere(String numberStr) {
		size++;
		numberMap.put( Integer.valueOf( size), numberStr);
		return size;
	}

	@Override
	public List<Integer> getNumber(int numId) {
		List<Integer> retList = new ArrayList<Integer>();
		if (numId > size) {
			logger.info(" ask:{} outbound of array: {}", numId, size);
			return retList;
		}
		if ( numberMap.containsKey( Integer.valueOf( numId) )) {
			String numStr = numberMap.get( Integer.valueOf(numId));
			String[] numStrArray = numStr.split(",");
			ArrayList<String> numStrList = new ArrayList<>(Arrays.asList(numStrArray));
			int length = numStrList.size();
			while ( length > 1) {
				int pos = (int)(Math.random()* length);
				String item = numStrList.get(pos).trim();
				retList.add( Integer.valueOf( item));
				
				logger.info("length:{}, pos:{}, item:{}", length, pos, item);
				numStrList.remove(pos);
				//numStrList.remove(item);
				length--;
			}
			logger.info("out of while, length:{}, item:{}", numStrList.size(), numStrList.get(0));
			retList.add(Integer.valueOf( numStrList.get(0).trim()));
			int ind =0;
			for (Integer item: retList) 
				logger.info("{} num:{}", ind++, item);
			
			
		} else {
			logger.info(" number Id:{} NOT FOUND", numId);
		}
		return retList;
	}

}
