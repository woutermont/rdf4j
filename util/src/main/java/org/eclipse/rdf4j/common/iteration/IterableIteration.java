/*******************************************************************************
 * Copyright (c) 2019 Eclipse RDF4J contributors.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Distribution License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/org/documents/edl-v10.php.
 *******************************************************************************/

package org.eclipse.rdf4j.common.iteration;

import java.lang.Iterable;
import java.util.Iterator;
import java.util.NoSuchElementException;

import org.eclipse.rdf4j.common.iterator.IterationIterator;

/**
 * An Iteration that is also an Iterable, the Iterator of which maps back to its own methods
 * 
 * @param <E> Object type of objects contained in the Iteration, and in the Iterator returned by the iterator() method.
 * @param <X> Exception type that is thrown when a problem occurs during iteration (using the methods of Iteration).
 * @see java.util.Iterator
 *
 * @author Wouter Termont
 */
public interface IterableIteration<E, X extends Exception> extends Iteration<E, X>, Iterable<E> {

	/**
	 * Returns an Iterator wrapping the methods of this Iteration.
	 * 
	 * @return an {@link IterationIterator}
	 */
	default public Iterator<E> iterator() {
		return new IterationIterator<E>(this);
	}

}
