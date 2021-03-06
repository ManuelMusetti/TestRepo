package main;

import java.awt.Point;
import java.util.ArrayList;

/**
 * Each instance of this class represents a features group. 
 * @author natan
 *
 */
public class GroupNode {
	/** The group minimum cardinality*/
	private int minCardinality=1;
	/** The group maximum cardinality*/
	private int maxCardinality=-1;
	/** The list of features that are members of this group*/
	private ArrayList<FeatureNode> subFeatures= new ArrayList<FeatureNode>();

	/**
	 * Creates a new default GroupNode. <br>
	 * The Default is a mandatory nameless commonality without sub-features or sub-groups.
	 * 
	 */
	public GroupNode(){}
	
	/**
	 * Creates a new GroupNode, based on the parameters. 
	 * 
	 * @param minCardinality - group minimum cardinality
	 * @param maxCardinality - group maximum cardinality
	 * @param subFeatures - the features which will be member of this group.
	 */
	public GroupNode(int minCardinality, int maxCardinality, ArrayList<FeatureNode> subFeatures){
		this.minCardinality=minCardinality;
		this.maxCardinality=maxCardinality;
		this.subFeatures=subFeatures;
	}

	
	
	/**
	 * Changes the cardinality of this group with the one given in the parameters.
	 * 
	 * @param min - group new minimum cardinality
	 * @param max - group new maximum cardinality
	 */
	public void setCardinality(int min, int max){
		this.minCardinality=min;
		this.maxCardinality=max;
	}

	/**
	 * Returns the cardinality of this group in the form of a Point object, <br>
	 * where the x coordinate represents the minimum cardinality and the y coordinate represents the maximum cardinality.
	 * 
	 * @return a Point object representing the cardinality of this group.
	 */
	public Point getCardinality(){
		return new Point(minCardinality, maxCardinality);
	}
}
