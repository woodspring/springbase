package woodspring.springbase.service.impl;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import woodspring.springbase.dto.NumberRepo;
import woodspring.springbase.entity.NumberH2;
import woodspring.springbase.service.NumberService;

@Service
@Qualifier("NumberH2Service")
public class NumberH2ServiceImpl implements NumberService{
	private final static Logger logger = LoggerFactory.getLogger(NumberH2ServiceImpl.class);
	int index = -99;
	
	@Autowired
	private NumberRepo numberRepo;

	@Override
	public int storeNumbere(String numberStr) {
		if (index == -99) {
			long count = numberRepo.count();
			if (count==0) index =0;
			else {
				index = Long.valueOf(count).intValue();
			}
		}
		index++;
		NumberH2 h2Number = new NumberH2( index, numberStr);
		h2Number = numberRepo.save(h2Number);
		logger.info("h2Number:{}", h2Number.toString());
		return index;
	}

	@Override
	public List<Integer> getNumber(int numId) {
		List<Integer> retList = new ArrayList<Integer>();
		NumberH2 h2Number = numberRepo.findById( Long.valueOf((long)numId)).get();
		if ( h2Number == null) {
			logger.info("{} NOT FOUND", numId);
			return retList;
		}
		logger.info("h2Number:{}", h2Number.toString());
		String[] numStrArray = h2Number.getNumberStr().split(",");
		ArrayList<String> numStrList = new ArrayList<>(Arrays.asList(numStrArray));
		int index = numStrList.size();
		while ( index > 1) {
			int randomPos = (int)(Math.random()*index);
			Integer item = Integer.valueOf( numStrList.get(randomPos).trim());
			retList.add(Integer.valueOf( numStrList.get(randomPos).trim()));
			logger.info("index:{}, pos:{}, number:{}", index, randomPos, item);
			numStrList.remove( randomPos);
			index--;
		}
		retList.add(Integer.valueOf( numStrList.get(0).trim()));
		
		return retList;
	}

}
