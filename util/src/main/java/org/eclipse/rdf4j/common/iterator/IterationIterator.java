/*******************************************************************************
 * Copyright (c) 2019 Eclipse RDF4J contributors.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Distribution License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/org/documents/edl-v10.php.
 *******************************************************************************/
package org.eclipse.rdf4j.common.iterator;

import java.io.IOException;
import java.util.Iterator;

import org.eclipse.rdf4j.common.iteration.Iteration;

/**
 * Wraps an Iteration as an Iterator, providing a trivial mapping to the iterating methods.
 * 
 * @param <E> Object type of objects contained in the Iteration/Iterator.
 * 
 * @author Wouter Termont
 */
public class IterationIterator<E> implements Iterator<E> {

	private final Iteration<? extends E, ? extends /* Runtime */ Exception> iteration;

	public IterationIterator(Iteration<? extends E, ? extends /* Runtime */ Exception> iteration) {
		this.iteration = iteration;
	}

	@Override
	public boolean hasNext() {
		try {
			return iteration.hasNext();
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	@Override
	public E next() {
		try {
			return iteration.next();
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	@Override
	public void remove() {
		try {
			iteration.remove();
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

}
