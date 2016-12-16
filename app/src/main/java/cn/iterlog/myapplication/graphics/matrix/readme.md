Matrix
public class Matrix 
extends Object 

java.lang.Object
   ↳	android.graphics.Matrix

The Matrix class holds a 3x3 matrix for transforming coordinates.

Summary
Nested classes
enum	Matrix.ScaleToFit
Controlls how the src rect should align into the dst rect for setRectToRect(). 
Constants
int	MPERSP_0
int	MPERSP_1
int	MPERSP_2
int	MSCALE_X
int	MSCALE_Y
int	MSKEW_X
int	MSKEW_Y
int	MTRANS_X
int	MTRANS_Y
Public constructors
Matrix()
Create an identity matrix
Matrix(Matrix src)
Create a matrix that is a (deep) copy of src
Public methods
boolean	equals(Object obj)
Returns true iff obj is a Matrix and its values equal our values.
void	getValues(float[] values)
Copy 9 values from the matrix into the array.
int	hashCode()
Returns a hash code value for the object.
boolean	invert(Matrix inverse)
If this matrix can be inverted, return true and if inverse is not null, set inverse to be the inverse of this matrix.
boolean	isAffine()
Gets whether this matrix is affine.
boolean	isIdentity()
Returns true if the matrix is identity.
void	mapPoints(float[] dst, int dstIndex, float[] src, int srcIndex, int pointCount)
Apply this matrix to the array of 2D points specified by src, and write the transformed points into the array of points specified by dst.
void	mapPoints(float[] dst, float[] src)
Apply this matrix to the array of 2D points specified by src, and write the transformed points into the array of points specified by dst.
void	mapPoints(float[] pts)
Apply this matrix to the array of 2D points, and write the transformed points back into the array
float	mapRadius(float radius)
Return the mean radius of a circle after it has been mapped by this matrix.
boolean	mapRect(RectF rect)
Apply this matrix to the rectangle, and write the transformed rectangle back into it.
boolean	mapRect(RectF dst, RectF src)
Apply this matrix to the src rectangle, and write the transformed rectangle into dst.
void	mapVectors(float[] vecs)
Apply this matrix to the array of 2D vectors, and write the transformed vectors back into the array.
void	mapVectors(float[] dst, int dstIndex, float[] src, int srcIndex, int vectorCount)
Apply this matrix to the array of 2D vectors specified by src, and write the transformed vectors into the array of vectors specified by dst.
void	mapVectors(float[] dst, float[] src)
Apply this matrix to the array of 2D vectors specified by src, and write the transformed vectors into the array of vectors specified by dst.
boolean	postConcat(Matrix other)
Postconcats the matrix with the specified matrix.
boolean	postRotate(float degrees, float px, float py)
Postconcats the matrix with the specified rotation.
boolean	postRotate(float degrees)
Postconcats the matrix with the specified rotation.
boolean	postScale(float sx, float sy, float px, float py)
Postconcats the matrix with the specified scale.
boolean	postScale(float sx, float sy)
Postconcats the matrix with the specified scale.
boolean	postSkew(float kx, float ky)
Postconcats the matrix with the specified skew.
boolean	postSkew(float kx, float ky, float px, float py)
Postconcats the matrix with the specified skew.
boolean	postTranslate(float dx, float dy)
Postconcats the matrix with the specified translation.
boolean	preConcat(Matrix other)
Preconcats the matrix with the specified matrix.
boolean	preRotate(float degrees)
Preconcats the matrix with the specified rotation.
boolean	preRotate(float degrees, float px, float py)
Preconcats the matrix with the specified rotation.
boolean	preScale(float sx, float sy)
Preconcats the matrix with the specified scale.
boolean	preScale(float sx, float sy, float px, float py)
Preconcats the matrix with the specified scale.
boolean	preSkew(float kx, float ky)
Preconcats the matrix with the specified skew.
boolean	preSkew(float kx, float ky, float px, float py)
Preconcats the matrix with the specified skew.
boolean	preTranslate(float dx, float dy)
Preconcats the matrix with the specified translation.
boolean	rectStaysRect()
Returns true if will map a rectangle to another rectangle.
void	reset()
Set the matrix to identity
void	set(Matrix src)
(deep) copy the src matrix into this matrix.
boolean	setConcat(Matrix a, Matrix b)
Set the matrix to the concatenation of the two specified matrices and return true.
boolean	setPolyToPoly(float[] src, int srcIndex, float[] dst, int dstIndex, int pointCount)
Set the matrix such that the specified src points would map to the specified dst points.
boolean	setRectToRect(RectF src, RectF dst, Matrix.ScaleToFit stf)
Set the matrix to the scale and translate values that map the source rectangle to the destination rectangle, returning true if the the result can be represented.
void	setRotate(float degrees, float px, float py)
Set the matrix to rotate by the specified number of degrees, with a pivot point at (px, py).
void	setRotate(float degrees)
Set the matrix to rotate about (0,0) by the specified number of degrees.
void	setScale(float sx, float sy)
Set the matrix to scale by sx and sy.
void	setScale(float sx, float sy, float px, float py)
Set the matrix to scale by sx and sy, with a pivot point at (px, py).
void	setSinCos(float sinValue, float cosValue, float px, float py)
Set the matrix to rotate by the specified sine and cosine values, with a pivot point at (px, py).
void	setSinCos(float sinValue, float cosValue)
Set the matrix to rotate by the specified sine and cosine values.
void	setSkew(float kx, float ky)
Set the matrix to skew by sx and sy.
void	setSkew(float kx, float ky, float px, float py)
Set the matrix to skew by sx and sy, with a pivot point at (px, py).
void	setTranslate(float dx, float dy)
Set the matrix to translate by (dx, dy).
void	setValues(float[] values)
Copy 9 values from the array into the matrix.
String	toShortString()
String	toString()
Returns a string representation of the object.
Protected methods
void	finalize()
Called by the garbage collector on an object when garbage collection determines that there are no more references to the object.
Inherited methods
From class java.lang.Object
Constants
MPERSP_0

Added in API level 1
int MPERSP_0
Constant Value: 6 (0x00000006)

MPERSP_1

Added in API level 1
int MPERSP_1
Constant Value: 7 (0x00000007)

MPERSP_2

Added in API level 1
int MPERSP_2
Constant Value: 8 (0x00000008)

MSCALE_X

Added in API level 1
int MSCALE_X
Constant Value: 0 (0x00000000)

MSCALE_Y

Added in API level 1
int MSCALE_Y
Constant Value: 4 (0x00000004)

MSKEW_X

Added in API level 1
int MSKEW_X
Constant Value: 1 (0x00000001)

MSKEW_Y

Added in API level 1
int MSKEW_Y
Constant Value: 3 (0x00000003)

MTRANS_X

Added in API level 1
int MTRANS_X
Constant Value: 2 (0x00000002)

MTRANS_Y

Added in API level 1
int MTRANS_Y
Constant Value: 5 (0x00000005)

Public constructors
Matrix

Added in API level 1
Matrix ()
Create an identity matrix

Matrix

Added in API level 1
Matrix (Matrix src)
Create a matrix that is a (deep) copy of src

Parameters
src	Matrix: The matrix to copy into this matrix
Public methods
equals

Added in API level 1
boolean equals (Object obj)
Returns true iff obj is a Matrix and its values equal our values.

Parameters
obj	Object: the reference object with which to compare.
Returns
boolean	true if this object is the same as the obj argument; false otherwise.
getValues

Added in API level 1
void getValues (float[] values)
Copy 9 values from the matrix into the array.

Parameters
values	float
hashCode

Added in API level 1
int hashCode ()
Returns a hash code value for the object. This method is supported for the benefit of hash tables such as those provided by HashMap.

The general contract of hashCode is:

Whenever it is invoked on the same object more than once during an execution of a Java application, the hashCode method must consistently return the same integer, provided no information used in equals comparisons on the object is modified. This integer need not remain consistent from one execution of an application to another execution of the same application.
If two objects are equal according to the equals(Object) method, then calling the hashCode method on each of the two objects must produce the same integer result.
It is not required that if two objects are unequal according to the equals(java.lang.Object) method, then calling the hashCode method on each of the two objects must produce distinct integer results. However, the programmer should be aware that producing distinct integer results for unequal objects may improve the performance of hash tables.
As much as is reasonably practical, the hashCode method defined by class Object does return distinct integers for distinct objects. (This is typically implemented by converting the internal address of the object into an integer, but this implementation technique is not required by the JavaTM programming language.)

Returns
int	a hash code value for this object.
invert

Added in API level 1
boolean invert (Matrix inverse)
If this matrix can be inverted, return true and if inverse is not null, set inverse to be the inverse of this matrix. If this matrix cannot be inverted, ignore inverse and return false.

Parameters
inverse	Matrix
Returns
boolean	
isAffine

Added in API level 21
boolean isAffine ()
Gets whether this matrix is affine. An affine matrix preserves straight lines and has no perspective.

Returns
boolean	Whether the matrix is affine.
isIdentity

Added in API level 1
boolean isIdentity ()
Returns true if the matrix is identity. This maybe faster than testing if (getType() == 0)

Returns
boolean	
mapPoints

Added in API level 1
void mapPoints (float[] dst, 
                int dstIndex, 
                float[] src, 
                int srcIndex, 
                int pointCount)
Apply this matrix to the array of 2D points specified by src, and write the transformed points into the array of points specified by dst. The two arrays represent their "points" as pairs of floats [x, y].

Parameters
dst	float: The array of dst points (x,y pairs)
dstIndex	int: The index of the first [x,y] pair of dst floats
src	float: The array of src points (x,y pairs)
srcIndex	int: The index of the first [x,y] pair of src floats
pointCount	int: The number of points (x,y pairs) to transform
mapPoints

Added in API level 1
void mapPoints (float[] dst, 
                float[] src)
Apply this matrix to the array of 2D points specified by src, and write the transformed points into the array of points specified by dst. The two arrays represent their "points" as pairs of floats [x, y].

Parameters
dst	float: The array of dst points (x,y pairs)
src	float: The array of src points (x,y pairs)
mapPoints

Added in API level 1
void mapPoints (float[] pts)
Apply this matrix to the array of 2D points, and write the transformed points back into the array

Parameters
pts	float: The array [x0, y0, x1, y1, ...] of points to transform.
mapRadius

Added in API level 1
float mapRadius (float radius)
Return the mean radius of a circle after it has been mapped by this matrix. NOTE: in perspective this value assumes the circle has its center at the origin.

Parameters
radius	float
Returns
float	
mapRect

Added in API level 1
boolean mapRect (RectF rect)
Apply this matrix to the rectangle, and write the transformed rectangle back into it. This is accomplished by transforming the 4 corners of rect, and then setting it to the bounds of those points

Parameters
rect	RectF: The rectangle to transform.
Returns
boolean	the result of calling rectStaysRect()
mapRect

Added in API level 1
boolean mapRect (RectF dst, 
                RectF src)
Apply this matrix to the src rectangle, and write the transformed rectangle into dst. This is accomplished by transforming the 4 corners of src, and then setting dst to the bounds of those points.

Parameters
dst	RectF: Where the transformed rectangle is written.
src	RectF: The original rectangle to be transformed.
Returns
boolean	the result of calling rectStaysRect()
mapVectors

Added in API level 1
void mapVectors (float[] vecs)
Apply this matrix to the array of 2D vectors, and write the transformed vectors back into the array. Note: this method does not apply the translation associated with the matrix. Use mapPoints(float[]) if you want the translation to be applied.

Parameters
vecs	float: The array [x0, y0, x1, y1, ...] of vectors to transform.
mapVectors

Added in API level 1
void mapVectors (float[] dst, 
                int dstIndex, 
                float[] src, 
                int srcIndex, 
                int vectorCount)
Apply this matrix to the array of 2D vectors specified by src, and write the transformed vectors into the array of vectors specified by dst. The two arrays represent their "vectors" as pairs of floats [x, y]. Note: this method does not apply the translation associated with the matrix. Use mapPoints(float[], int, float[], int, int) if you want the translation to be applied.

Parameters
dst	float: The array of dst vectors (x,y pairs)
dstIndex	int: The index of the first [x,y] pair of dst floats
src	float: The array of src vectors (x,y pairs)
srcIndex	int: The index of the first [x,y] pair of src floats
vectorCount	int: The number of vectors (x,y pairs) to transform
mapVectors

Added in API level 1
void mapVectors (float[] dst, 
                float[] src)
Apply this matrix to the array of 2D vectors specified by src, and write the transformed vectors into the array of vectors specified by dst. The two arrays represent their "vectors" as pairs of floats [x, y]. Note: this method does not apply the translation associated with the matrix. Use mapPoints(float[], float[]) if you want the translation to be applied.

Parameters
dst	float: The array of dst vectors (x,y pairs)
src	float: The array of src vectors (x,y pairs)
postConcat

Added in API level 1
boolean postConcat (Matrix other)
Postconcats the matrix with the specified matrix. M' = other * M

Parameters
other	Matrix
Returns
boolean	
postRotate

Added in API level 1
boolean postRotate (float degrees, 
                float px, 
                float py)
Postconcats the matrix with the specified rotation. M' = R(degrees, px, py) * M

Parameters
degrees	float
px	float
py	float
Returns
boolean	
postRotate

Added in API level 1
boolean postRotate (float degrees)
Postconcats the matrix with the specified rotation. M' = R(degrees) * M

Parameters
degrees	float
Returns
boolean	
postScale

Added in API level 1
boolean postScale (float sx, 
                float sy, 
                float px, 
                float py)
Postconcats the matrix with the specified scale. M' = S(sx, sy, px, py) * M

Parameters
sx	float
sy	float
px	float
py	float
Returns
boolean	
postScale

Added in API level 1
boolean postScale (float sx, 
                float sy)
Postconcats the matrix with the specified scale. M' = S(sx, sy) * M

Parameters
sx	float
sy	float
Returns
boolean	
postSkew

Added in API level 1
boolean postSkew (float kx, 
                float ky)
Postconcats the matrix with the specified skew. M' = K(kx, ky) * M

Parameters
kx	float
ky	float
Returns
boolean	
postSkew

Added in API level 1
boolean postSkew (float kx, 
                float ky, 
                float px, 
                float py)
Postconcats the matrix with the specified skew. M' = K(kx, ky, px, py) * M

Parameters
kx	float
ky	float
px	float
py	float
Returns
boolean	
postTranslate

Added in API level 1
boolean postTranslate (float dx, 
                float dy)
Postconcats the matrix with the specified translation. M' = T(dx, dy) * M

Parameters
dx	float
dy	float
Returns
boolean	
preConcat

Added in API level 1
boolean preConcat (Matrix other)
Preconcats the matrix with the specified matrix. M' = M * other

Parameters
other	Matrix
Returns
boolean	
preRotate

Added in API level 1
boolean preRotate (float degrees)
Preconcats the matrix with the specified rotation. M' = M * R(degrees)

Parameters
degrees	float
Returns
boolean	
preRotate

Added in API level 1
boolean preRotate (float degrees, 
                float px, 
                float py)
Preconcats the matrix with the specified rotation. M' = M * R(degrees, px, py)

Parameters
degrees	float
px	float
py	float
Returns
boolean	
preScale

Added in API level 1
boolean preScale (float sx, 
                float sy)
Preconcats the matrix with the specified scale. M' = M * S(sx, sy)

Parameters
sx	float
sy	float
Returns
boolean	
preScale

Added in API level 1
boolean preScale (float sx, 
                float sy, 
                float px, 
                float py)
Preconcats the matrix with the specified scale. M' = M * S(sx, sy, px, py)

Parameters
sx	float
sy	float
px	float
py	float
Returns
boolean	
preSkew

Added in API level 1
boolean preSkew (float kx, 
                float ky)
Preconcats the matrix with the specified skew. M' = M * K(kx, ky)

Parameters
kx	float
ky	float
Returns
boolean	
preSkew

Added in API level 1
boolean preSkew (float kx, 
                float ky, 
                float px, 
                float py)
Preconcats the matrix with the specified skew. M' = M * K(kx, ky, px, py)

Parameters
kx	float
ky	float
px	float
py	float
Returns
boolean	
preTranslate

Added in API level 1
boolean preTranslate (float dx, 
                float dy)
Preconcats the matrix with the specified translation. M' = M * T(dx, dy)

Parameters
dx	float
dy	float
Returns
boolean	
rectStaysRect

Added in API level 1
boolean rectStaysRect ()
Returns true if will map a rectangle to another rectangle. This can be true if the matrix is identity, scale-only, or rotates a multiple of 90 degrees.

Returns
boolean	
reset

Added in API level 1
void reset ()
Set the matrix to identity

set

Added in API level 1
void set (Matrix src)
(deep) copy the src matrix into this matrix. If src is null, reset this matrix to the identity matrix.

Parameters
src	Matrix
setConcat

Added in API level 1
boolean setConcat (Matrix a, 
                Matrix b)
Set the matrix to the concatenation of the two specified matrices and return true.

Either of the two matrices may also be the target matrix, that is matrixA.setConcat(matrixA, matrixB); is valid.

In GINGERBREAD_MR1 and below, this function returns true only if the result can be represented. In HONEYCOMB and above, it always returns true.

Parameters
a	Matrix
b	Matrix
Returns
boolean	
setPolyToPoly

Added in API level 1
boolean setPolyToPoly (float[] src, 
                int srcIndex, 
                float[] dst, 
                int dstIndex, 
                int pointCount)
Set the matrix such that the specified src points would map to the specified dst points. The "points" are represented as an array of floats, order [x0, y0, x1, y1, ...], where each "point" is 2 float values.

Parameters
src	float: The array of src [x,y] pairs (points)
srcIndex	int: Index of the first pair of src values
dst	float: The array of dst [x,y] pairs (points)
dstIndex	int: Index of the first pair of dst values
pointCount	int: The number of pairs/points to be used. Must be [0..4]
Returns
boolean	true if the matrix was set to the specified transformation
setRectToRect

Added in API level 1
boolean setRectToRect (RectF src, 
                RectF dst, 
                Matrix.ScaleToFit stf)
Set the matrix to the scale and translate values that map the source rectangle to the destination rectangle, returning true if the the result can be represented.

Parameters
src	RectF: the source rectangle to map from.
dst	RectF: the destination rectangle to map to.
stf	Matrix.ScaleToFit: the ScaleToFit option
Returns
boolean	true if the matrix can be represented by the rectangle mapping.
setRotate

Added in API level 1
void setRotate (float degrees, 
                float px, 
                float py)
Set the matrix to rotate by the specified number of degrees, with a pivot point at (px, py). The pivot point is the coordinate that should remain unchanged by the specified transformation.

Parameters
degrees	float
px	float
py	float
setRotate

Added in API level 1
void setRotate (float degrees)
Set the matrix to rotate about (0,0) by the specified number of degrees.

Parameters
degrees	float
setScale

Added in API level 1
void setScale (float sx, 
                float sy)
Set the matrix to scale by sx and sy.

Parameters
sx	float
sy	float
setScale

Added in API level 1
void setScale (float sx, 
                float sy, 
                float px, 
                float py)
Set the matrix to scale by sx and sy, with a pivot point at (px, py). The pivot point is the coordinate that should remain unchanged by the specified transformation.

Parameters
sx	float
sy	float
px	float
py	float
setSinCos

Added in API level 1
void setSinCos (float sinValue, 
                float cosValue, 
                float px, 
                float py)
Set the matrix to rotate by the specified sine and cosine values, with a pivot point at (px, py). The pivot point is the coordinate that should remain unchanged by the specified transformation.

Parameters
sinValue	float
cosValue	float
px	float
py	float
setSinCos

Added in API level 1
void setSinCos (float sinValue, 
                float cosValue)
Set the matrix to rotate by the specified sine and cosine values.

Parameters
sinValue	float
cosValue	float
setSkew

Added in API level 1
void setSkew (float kx, 
                float ky)
Set the matrix to skew by sx and sy.

Parameters
kx	float
ky	float
setSkew

Added in API level 1
void setSkew (float kx, 
                float ky, 
                float px, 
                float py)
Set the matrix to skew by sx and sy, with a pivot point at (px, py). The pivot point is the coordinate that should remain unchanged by the specified transformation.

Parameters
kx	float
ky	float
px	float
py	float
setTranslate

Added in API level 1
void setTranslate (float dx, 
                float dy)
Set the matrix to translate by (dx, dy).

Parameters
dx	float
dy	float
setValues

Added in API level 1
void setValues (float[] values)
Copy 9 values from the array into the matrix. Depending on the implementation of Matrix, these may be transformed into 16.16 integers in the Matrix, such that a subsequent call to getValues() will not yield exactly the same values.

Parameters
values	float
toShortString

Added in API level 1
String toShortString ()
Returns
String	
toString

Added in API level 1
String toString ()
Returns a string representation of the object. In general, the toString method returns a string that "textually represents" this object. The result should be a concise but informative representation that is easy for a person to read. It is recommended that all subclasses override this method.

The toString method for class Object returns a string consisting of the name of the class of which the object is an instance, the at-sign character `@', and the unsigned hexadecimal representation of the hash code of the object. In other words, this method returns a string equal to the value of:

 getClass().getName() + '@' + Integer.toHexString(hashCode())
 
Returns
String	a string representation of the object.
Protected methods
finalize

Added in API level 1
void finalize ()
Called by the garbage collector on an object when garbage collection determines that there are no more references to the object. A subclass overrides the finalize method to dispose of system resources or to perform other cleanup.

The general contract of finalize is that it is invoked if and when the JavaTM virtual machine has determined that there is no longer any means by which this object can be accessed by any thread that has not yet died, except as a result of an action taken by the finalization of some other object or class which is ready to be finalized. The finalize method may take any action, including making this object available again to other threads; the usual purpose of finalize, however, is to perform cleanup actions before the object is irrevocably discarded. For example, the finalize method for an object that represents an input/output connection might perform explicit I/O transactions to break the connection before the object is permanently discarded.

The finalize method of class Object performs no special action; it simply returns normally. Subclasses of Object may override this definition.

The Java programming language does not guarantee which thread will invoke the finalize method for any given object. It is guaranteed, however, that the thread that invokes finalize will not be holding any user-visible synchronization locks when finalize is invoked. If an uncaught exception is thrown by the finalize method, the exception is ignored and finalization of that object terminates.

After the finalize method has been invoked for an object, no further action is taken until the Java virtual machine has again determined that there is no longer any means by which this object can be accessed by any thread that has not yet died, including possible actions by other objects or classes which are ready to be finalized, at which point the object may be discarded.

The finalize method is never invoked more than once by a Java virtual machine for any given object.

Any exception thrown by the finalize method causes the finalization of this object to be halted, but is otherwise ignored.

Throws
Throwable	