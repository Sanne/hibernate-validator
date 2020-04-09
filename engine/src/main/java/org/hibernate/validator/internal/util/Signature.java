/*
 * Hibernate Validator, declare and validate application constraints
 *
 * License: Apache License, Version 2.0
 * See the license.txt file in the root directory or <http://www.apache.org/licenses/LICENSE-2.0>.
 */
package org.hibernate.validator.internal.util;

import java.util.Arrays;
import java.util.Objects;

public final class Signature {

	private final String name;
	private final Class<?>[] parameterTypes;

	public Signature(final String name, final Class<?>[] parameterTypes) {
		Objects.requireNonNull( name );
		Objects.requireNonNull( parameterTypes );
		this.name = name;
		this.parameterTypes = parameterTypes;
	}

	@Override
	public boolean equals(final Object o) {
		if ( this == o ) {
			return true;
		}
		if ( o == null || Signature.class != o.getClass() ) {
			return false;
		}
		final Signature signature = (Signature) o;
		return name.equals( signature.name ) &&
				Arrays.equals( parameterTypes, signature.parameterTypes );
	}

	@Override
	public int hashCode() {
		int result = Objects.hash( name );
		result = 31 * result + Arrays.hashCode( parameterTypes );
		return result;
	}

	public String toString() {
		StringBuilder signature = new StringBuilder();
		signature.append( name ).append( '(' );
		boolean separator = false;
		for ( Class<?> parameterType : parameterTypes ) {
			if ( separator ) {
				signature.append( ", " );
			}
			else {
				separator = true;
			}
			signature.append( parameterType.getName() );
		}
		signature.append( ')' );
		return signature.toString();
	}

}
