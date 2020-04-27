package com.kebabwarrios.es;

import java.util.ArrayList;
import java.util.HashMap;

public final class MathProcedures {
  /**
   * @param doc  list of strings
   * @param term String represents a term
   * @return term frequency of term in document
   */
  public static double tf(String[] doc, String term) { 
    double result = 0; 

    for (String word : doc) { 
      if (term.equalsIgnoreCase(word)) {
        result++;
      }
    } 

    return (result / doc.length); 
  }

  /**
   * @param docs list of list of strings represents the dataset
   * @param term String represents a term
   * @return the inverse term frequency of term in documents
   */
  private static double idf(HashMap<String, String[]> docs, String term) { 
    double total = 0; 

    for (String[] words : docs.values()) {
      for (String word : words) {
        if (term.equals(word)) { 
          total++; 

          break;   
        }
      }
    }

    return idfValidator(docs.size(), total); 
  }

  private static double idfValidator(int docsSize, double total) {
    return (Math.log(docsSize/ total) + 1);
  }

  /**
   * @param doc  a text document
   * @param docs all documents
   * @param term term
   * @return the TF-IDF of term
   */
  public static double tfIdf(String[] doc, HashMap<String, String[]> docs, String term) {
    return (tf(doc, term) * idf(docs, term));
  }
  
  public static Double[] matrixMultiplication(Double[] vectorOne, Double[] vectorTwo) {
    ArrayList<Double> result = new ArrayList<>();
    
    if (vectorOne.length >= vectorOne.length) {
      for (int x = 0; x < vectorOne.length; x++) {
        result.add((vectorOne[x] * vectorTwo[x % vectorTwo.length]));
      }
    } else {
      for (int x = 0; x < vectorTwo.length; x++) {
        result.add((vectorTwo[x] * vectorOne[x % vectorOne.length]));
      }
    }
    
    return result.toArray(new Double[result.size()]);
  }
}
