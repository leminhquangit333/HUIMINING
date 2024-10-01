package ca.pfv.spmf.algorithmmanager.descriptions;

import java.io.IOException;

import ca.pfv.spmf.algorithmmanager.AlgorithmType;
import ca.pfv.spmf.algorithmmanager.DescriptionOfAlgorithm;
import ca.pfv.spmf.algorithmmanager.DescriptionOfParameter;
import ca.pfv.spmf.algorithms.frequentpatterns.HMiner_CLosed.AlgoHMiner_Closed;
import ca.pfv.spmf.algorithms.frequentpatterns.hui_miner.AlgoCHUIMiner;
/* This file is copyright (c) 2008-2016 Philippe Fournier-Viger
* 
* This file is part of the SPMF DATA MINING SOFTWARE
* (http://www.philippe-fournier-viger.com/spmf).
* 
* SPMF is free software: you can redistribute it and/or modify it under the
* terms of the GNU General Public License as published by the Free Software
* Foundation, either version 3 of the License, or (at your option) any later
* version.
* 
* SPMF is distributed in the hope that it will be useful, but WITHOUT ANY
* WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS FOR
* A PARTICULAR PURPOSE. See the GNU General Public License for more details.
* You should have received a copy of the GNU General Public License along with
* SPMF. If not, see <http://www.gnu.org/licenses/>.
*/

/**
 * This class describes the CHUI-Miner algorithm parameters. 
 * It is designed to be used by the graphical and command line interface.
 * 
 * @see AlgoCHUIMiner
 * @author Philippe Fournier-Viger
 */
public class DescriptionAlgoHMinerClosed extends DescriptionOfAlgorithm {

	/**
	 * Default constructor
	 */
	public DescriptionAlgoHMinerClosed(){
	}

	@Override
	public String getName() {
		return "HMinerClosed";
	}

	@Override
	public String getAlgorithmCategory() {
		return "HIGH-UTILITY PATTERN MINING";
	}

	@Override
	public String getURLOfDocumentation() {
		return "http://www.philippe-fournier-viger.com/spmf/Closed_Hminer.php";
	}

	@Override
	public void runAlgorithm(String[] parameters, String inputFile, String outputFile) throws IOException {
		long minutil = getParamAsLong(parameters[0]);
		// Applying the algorithm
		AlgoHMiner_Closed algo = new AlgoHMiner_Closed();
		algo.runAlgorithm(inputFile, outputFile, minutil, true, true);
		algo.printStats();
	}

	@Override
	public DescriptionOfParameter[] getParametersDescription() {
        
		DescriptionOfParameter[] parameters = new DescriptionOfParameter[1];
		parameters[0] = new DescriptionOfParameter("Minimum utility", "(e.g. 30)", Long.class, false);
		return parameters;
	}

	@Override
	public String getImplementationAuthorNames() {
		return "github: limuhangk";
	}

	@Override
	public String[] getInputFileTypes() {
		return new String[]{"Database of instances","Transaction database", "Transaction database with utility values"};
	}

	@Override
	public String[] getOutputFileTypes() {
		return new String[]{"Patterns",  "Closed patterns","High-utility patterns","Closed itemsets","High-utility itemsets","Closed high-utility itemsets"};
	}
	@Override
	public AlgorithmType getAlgorithmType() {
		return AlgorithmType.DATA_MINING;
	}
}
