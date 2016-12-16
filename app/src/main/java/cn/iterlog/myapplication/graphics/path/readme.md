Path
public class Path 
extends Object 

java.lang.Object
   ↳	android.graphics.Path

The Path class encapsulates compound (multiple contour) geometric paths consisting of straight line segments, quadratic curves, and cubic curves. It can be drawn with canvas.drawPath(path, paint), either filled or stroked (based on the paint's Style), or it can be used for clipping or to draw text on a path.

Summary
Nested classes
enum	Path.Direction
Specifies how closed shapes (e.g. 
enum	Path.FillType
Enum for the ways a path may be filled. 
enum	Path.Op
The logical operations that can be performed when combining two paths. 
Public constructors
Path()
Create an empty path
Path(Path src)
Create a new path, copying the contents from the src path.
Public methods
void	addArc(float left, float top, float right, float bottom, float startAngle, float sweepAngle)
Add the specified arc to the path as a new contour.
void	addArc(RectF oval, float startAngle, float sweepAngle)
Add the specified arc to the path as a new contour.
void	addCircle(float x, float y, float radius, Path.Direction dir)
Add a closed circle contour to the path
void	addOval(RectF oval, Path.Direction dir)
Add a closed oval contour to the path
void	addOval(float left, float top, float right, float bottom, Path.Direction dir)
Add a closed oval contour to the path
void	addPath(Path src, Matrix matrix)
Add a copy of src to the path, transformed by matrix
void	addPath(Path src)
Add a copy of src to the path
void	addPath(Path src, float dx, float dy)
Add a copy of src to the path, offset by (dx,dy)
void	addRect(RectF rect, Path.Direction dir)
Add a closed rectangle contour to the path
void	addRect(float left, float top, float right, float bottom, Path.Direction dir)
Add a closed rectangle contour to the path
void	addRoundRect(RectF rect, float rx, float ry, Path.Direction dir)
Add a closed round-rectangle contour to the path
void	addRoundRect(float left, float top, float right, float bottom, float rx, float ry, Path.Direction dir)
Add a closed round-rectangle contour to the path
void	addRoundRect(RectF rect, float[] radii, Path.Direction dir)
Add a closed round-rectangle contour to the path.
void	addRoundRect(float left, float top, float right, float bottom, float[] radii, Path.Direction dir)
Add a closed round-rectangle contour to the path.
void	arcTo(RectF oval, float startAngle, float sweepAngle, boolean forceMoveTo)
Append the specified arc to the path as a new contour.
void	arcTo(float left, float top, float right, float bottom, float startAngle, float sweepAngle, boolean forceMoveTo)
Append the specified arc to the path as a new contour.
void	arcTo(RectF oval, float startAngle, float sweepAngle)
Append the specified arc to the path as a new contour.
void	close()
Close the current contour.
void	computeBounds(RectF bounds, boolean exact)
Compute the bounds of the control points of the path, and write the answer into bounds.
void	cubicTo(float x1, float y1, float x2, float y2, float x3, float y3)
Add a cubic bezier from the last point, approaching control points (x1,y1) and (x2,y2), and ending at (x3,y3).
Path.FillType	getFillType()
Return the path's fill type.
void	incReserve(int extraPtCount)
Hint to the path to prepare for adding more points.
boolean	isConvex()
Returns the path's convexity, as defined by the content of the path.
boolean	isEmpty()
Returns true if the path is empty (contains no lines or curves)
boolean	isInverseFillType()
Returns true if the filltype is one of the INVERSE variants
boolean	isRect(RectF rect)
Returns true if the path specifies a rectangle.
void	lineTo(float x, float y)
Add a line from the last point to the specified point (x,y).
void	moveTo(float x, float y)
Set the beginning of the next contour to the point (x,y).
void	offset(float dx, float dy, Path dst)
Offset the path by (dx,dy)
void	offset(float dx, float dy)
Offset the path by (dx,dy)
boolean	op(Path path1, Path path2, Path.Op op)
Set this path to the result of applying the Op to the two specified paths.
boolean	op(Path path, Path.Op op)
Set this path to the result of applying the Op to this path and the specified path.
void	quadTo(float x1, float y1, float x2, float y2)
Add a quadratic bezier from the last point, approaching control point (x1,y1), and ending at (x2,y2).
void	rCubicTo(float x1, float y1, float x2, float y2, float x3, float y3)
Same as cubicTo, but the coordinates are considered relative to the current point on this contour.
void	rLineTo(float dx, float dy)
Same as lineTo, but the coordinates are considered relative to the last point on this contour.
void	rMoveTo(float dx, float dy)
Set the beginning of the next contour relative to the last point on the previous contour.
void	rQuadTo(float dx1, float dy1, float dx2, float dy2)
Same as quadTo, but the coordinates are considered relative to the last point on this contour.
void	reset()
Clear any lines and curves from the path, making it empty.
void	rewind()
Rewinds the path: clears any lines and curves from the path but keeps the internal data structure for faster reuse.
void	set(Path src)
Replace the contents of this with the contents of src.
void	setFillType(Path.FillType ft)
Set the path's fill type.
void	setLastPoint(float dx, float dy)
Sets the last point of the path.
void	toggleInverseFillType()
Toggles the INVERSE state of the filltype
void	transform(Matrix matrix, Path dst)
Transform the points in this path by matrix, and write the answer into dst.
void	transform(Matrix matrix)
Transform the points in this path by matrix.
Protected methods
void	finalize()
Called by the garbage collector on an object when garbage collection determines that there are no more references to the object.
Inherited methods
From class java.lang.Object
Public constructors
Path

Added in API level 1
Path ()
Create an empty path

Path

Added in API level 1
Path (Path src)
Create a new path, copying the contents from the src path.

Parameters
src	Path: The path to copy from when initializing the new path
Public methods
addArc

Added in API level 21
void addArc (float left, 
                float top, 
                float right, 
                float bottom, 
                float startAngle, 
                float sweepAngle)
Add the specified arc to the path as a new contour.

Parameters
left	float
top	float
right	float
bottom	float
startAngle	float: Starting angle (in degrees) where the arc begins
sweepAngle	float: Sweep angle (in degrees) measured clockwise
addArc

Added in API level 1
void addArc (RectF oval, 
                float startAngle, 
                float sweepAngle)
Add the specified arc to the path as a new contour.

Parameters
oval	RectF: The bounds of oval defining the shape and size of the arc
startAngle	float: Starting angle (in degrees) where the arc begins
sweepAngle	float: Sweep angle (in degrees) measured clockwise
addCircle

Added in API level 1
void addCircle (float x, 
                float y, 
                float radius, 
                Path.Direction dir)
Add a closed circle contour to the path

Parameters
x	float: The x-coordinate of the center of a circle to add to the path
y	float: The y-coordinate of the center of a circle to add to the path
radius	float: The radius of a circle to add to the path
dir	Path.Direction: The direction to wind the circle's contour
addOval

Added in API level 1
void addOval (RectF oval, 
                Path.Direction dir)
Add a closed oval contour to the path

Parameters
oval	RectF: The bounds of the oval to add as a closed contour to the path
dir	Path.Direction: The direction to wind the oval's contour
addOval

Added in API level 21
void addOval (float left, 
                float top, 
                float right, 
                float bottom, 
                Path.Direction dir)
Add a closed oval contour to the path

Parameters
left	float
top	float
right	float
bottom	float
dir	Path.Direction: The direction to wind the oval's contour
addPath

Added in API level 1
void addPath (Path src, 
                Matrix matrix)
Add a copy of src to the path, transformed by matrix

Parameters
src	Path: The path to add as a new contour
matrix	Matrix
addPath

Added in API level 1
void addPath (Path src)
Add a copy of src to the path

Parameters
src	Path: The path that is appended to the current path
addPath

Added in API level 1
void addPath (Path src, 
                float dx, 
                float dy)
Add a copy of src to the path, offset by (dx,dy)

Parameters
src	Path: The path to add as a new contour
dx	float: The amount to translate the path in X as it is added
dy	float
addRect

Added in API level 1
void addRect (RectF rect, 
                Path.Direction dir)
Add a closed rectangle contour to the path

Parameters
rect	RectF: The rectangle to add as a closed contour to the path
dir	Path.Direction: The direction to wind the rectangle's contour
addRect

Added in API level 1
void addRect (float left, 
                float top, 
                float right, 
                float bottom, 
                Path.Direction dir)
Add a closed rectangle contour to the path

Parameters
left	float: The left side of a rectangle to add to the path
top	float: The top of a rectangle to add to the path
right	float: The right side of a rectangle to add to the path
bottom	float: The bottom of a rectangle to add to the path
dir	Path.Direction: The direction to wind the rectangle's contour
addRoundRect

Added in API level 1
void addRoundRect (RectF rect, 
                float rx, 
                float ry, 
                Path.Direction dir)
Add a closed round-rectangle contour to the path

Parameters
rect	RectF: The bounds of a round-rectangle to add to the path
rx	float: The x-radius of the rounded corners on the round-rectangle
ry	float: The y-radius of the rounded corners on the round-rectangle
dir	Path.Direction: The direction to wind the round-rectangle's contour
addRoundRect

Added in API level 21
void addRoundRect (float left, 
                float top, 
                float right, 
                float bottom, 
                float rx, 
                float ry, 
                Path.Direction dir)
Add a closed round-rectangle contour to the path

Parameters
left	float
top	float
right	float
bottom	float
rx	float: The x-radius of the rounded corners on the round-rectangle
ry	float: The y-radius of the rounded corners on the round-rectangle
dir	Path.Direction: The direction to wind the round-rectangle's contour
addRoundRect

Added in API level 1
void addRoundRect (RectF rect, 
                float[] radii, 
                Path.Direction dir)
Add a closed round-rectangle contour to the path. Each corner receives two radius values [X, Y]. The corners are ordered top-left, top-right, bottom-right, bottom-left

Parameters
rect	RectF: The bounds of a round-rectangle to add to the path
radii	float: Array of 8 values, 4 pairs of [X,Y] radii
dir	Path.Direction: The direction to wind the round-rectangle's contour
addRoundRect

Added in API level 21
void addRoundRect (float left, 
                float top, 
                float right, 
                float bottom, 
                float[] radii, 
                Path.Direction dir)
Add a closed round-rectangle contour to the path. Each corner receives two radius values [X, Y]. The corners are ordered top-left, top-right, bottom-right, bottom-left

Parameters
left	float
top	float
right	float
bottom	float
radii	float: Array of 8 values, 4 pairs of [X,Y] radii
dir	Path.Direction: The direction to wind the round-rectangle's contour
arcTo

Added in API level 1
void arcTo (RectF oval, 
                float startAngle, 
                float sweepAngle, 
                boolean forceMoveTo)
Append the specified arc to the path as a new contour. If the start of the path is different from the path's current last point, then an automatic lineTo() is added to connect the current contour to the start of the arc. However, if the path is empty, then we call moveTo() with the first point of the arc.

Parameters
oval	RectF: The bounds of oval defining shape and size of the arc
startAngle	float: Starting angle (in degrees) where the arc begins
sweepAngle	float: Sweep angle (in degrees) measured clockwise, treated mod 360.
forceMoveTo	boolean: If true, always begin a new contour with the arc
arcTo

Added in API level 21
void arcTo (float left, 
                float top, 
                float right, 
                float bottom, 
                float startAngle, 
                float sweepAngle, 
                boolean forceMoveTo)
Append the specified arc to the path as a new contour. If the start of the path is different from the path's current last point, then an automatic lineTo() is added to connect the current contour to the start of the arc. However, if the path is empty, then we call moveTo() with the first point of the arc.

Parameters
left	float
top	float
right	float
bottom	float
startAngle	float: Starting angle (in degrees) where the arc begins
sweepAngle	float: Sweep angle (in degrees) measured clockwise, treated mod 360.
forceMoveTo	boolean: If true, always begin a new contour with the arc
arcTo

Added in API level 1
void arcTo (RectF oval, 
                float startAngle, 
                float sweepAngle)
Append the specified arc to the path as a new contour. If the start of the path is different from the path's current last point, then an automatic lineTo() is added to connect the current contour to the start of the arc. However, if the path is empty, then we call moveTo() with the first point of the arc.

Parameters
oval	RectF: The bounds of oval defining shape and size of the arc
startAngle	float: Starting angle (in degrees) where the arc begins
sweepAngle	float: Sweep angle (in degrees) measured clockwise
close

Added in API level 1
void close ()
Close the current contour. If the current point is not equal to the first point of the contour, a line segment is automatically added.

computeBounds

Added in API level 1
void computeBounds (RectF bounds, 
                boolean exact)
Compute the bounds of the control points of the path, and write the answer into bounds. If the path contains 0 or 1 points, the bounds is set to (0,0,0,0)

Parameters
bounds	RectF: Returns the computed bounds of the path's control points.
exact	boolean: This parameter is no longer used.
cubicTo

Added in API level 1
void cubicTo (float x1, 
                float y1, 
                float x2, 
                float y2, 
                float x3, 
                float y3)
Add a cubic bezier from the last point, approaching control points (x1,y1) and (x2,y2), and ending at (x3,y3). If no moveTo() call has been made for this contour, the first point is automatically set to (0,0).

Parameters
x1	float: The x-coordinate of the 1st control point on a cubic curve
y1	float: The y-coordinate of the 1st control point on a cubic curve
x2	float: The x-coordinate of the 2nd control point on a cubic curve
y2	float: The y-coordinate of the 2nd control point on a cubic curve
x3	float: The x-coordinate of the end point on a cubic curve
y3	float: The y-coordinate of the end point on a cubic curve
getFillType

Added in API level 1
Path.FillType getFillType ()
Return the path's fill type. This defines how "inside" is computed. The default value is WINDING.

Returns
Path.FillType	the path's fill type
incReserve

Added in API level 1
void incReserve (int extraPtCount)
Hint to the path to prepare for adding more points. This can allow the path to more efficiently allocate its storage.

Parameters
extraPtCount	int: The number of extra points that may be added to this path
isConvex

Added in API level 21
boolean isConvex ()
Returns the path's convexity, as defined by the content of the path.

A path is convex if it has a single contour, and only ever curves in a single direction.

This function will calculate the convexity of the path from its control points, and cache the result.

Returns
boolean	True if the path is convex.
isEmpty

Added in API level 1
boolean isEmpty ()
Returns true if the path is empty (contains no lines or curves)

Returns
boolean	true if the path is empty (contains no lines or curves)
isInverseFillType

Added in API level 1
boolean isInverseFillType ()
Returns true if the filltype is one of the INVERSE variants

Returns
boolean	true if the filltype is one of the INVERSE variants
isRect

Added in API level 1
boolean isRect (RectF rect)
Returns true if the path specifies a rectangle. If so, and if rect is not null, set rect to the bounds of the path. If the path does not specify a rectangle, return false and ignore rect.

Parameters
rect	RectF: If not null, returns the bounds of the path if it specifies a rectangle
Returns
boolean	true if the path specifies a rectangle
lineTo

Added in API level 1
void lineTo (float x, 
                float y)
Add a line from the last point to the specified point (x,y). If no moveTo() call has been made for this contour, the first point is automatically set to (0,0).

Parameters
x	float: The x-coordinate of the end of a line
y	float: The y-coordinate of the end of a line
moveTo

Added in API level 1
void moveTo (float x, 
                float y)
Set the beginning of the next contour to the point (x,y).

Parameters
x	float: The x-coordinate of the start of a new contour
y	float: The y-coordinate of the start of a new contour
offset

Added in API level 1
void offset (float dx, 
                float dy, 
                Path dst)
Offset the path by (dx,dy)

Parameters
dx	float: The amount in the X direction to offset the entire path
dy	float: The amount in the Y direction to offset the entire path
dst	Path: The translated path is written here. If this is null, then the original path is modified.
offset

Added in API level 1
void offset (float dx, 
                float dy)
Offset the path by (dx,dy)

Parameters
dx	float: The amount in the X direction to offset the entire path
dy	float: The amount in the Y direction to offset the entire path
op

Added in API level 19
boolean op (Path path1, 
                Path path2, 
                Path.Op op)
Set this path to the result of applying the Op to the two specified paths. The resulting path will be constructed from non-overlapping contours. The curve order is reduced where possible so that cubics may be turned into quadratics, and quadratics maybe turned into lines.

Parameters
path1	Path: The first operand (for difference, the minuend)
path2	Path: The second operand (for difference, the subtrahend)
op	Path.Op
Returns
boolean	True if operation succeeded, false otherwise and this path remains unmodified.
See also:

Path.Op
op(Path, android.graphics.Path.Op)
op

Added in API level 19
boolean op (Path path, 
                Path.Op op)
Set this path to the result of applying the Op to this path and the specified path. The resulting path will be constructed from non-overlapping contours. The curve order is reduced where possible so that cubics may be turned into quadratics, and quadratics maybe turned into lines.

Parameters
path	Path: The second operand (for difference, the subtrahend)
op	Path.Op
Returns
boolean	True if operation succeeded, false otherwise and this path remains unmodified.
See also:

Path.Op
op(Path, Path, android.graphics.Path.Op)
quadTo

Added in API level 1
void quadTo (float x1, 
                float y1, 
                float x2, 
                float y2)
Add a quadratic bezier from the last point, approaching control point (x1,y1), and ending at (x2,y2). If no moveTo() call has been made for this contour, the first point is automatically set to (0,0).

Parameters
x1	float: The x-coordinate of the control point on a quadratic curve
y1	float: The y-coordinate of the control point on a quadratic curve
x2	float: The x-coordinate of the end point on a quadratic curve
y2	float: The y-coordinate of the end point on a quadratic curve
rCubicTo

Added in API level 1
void rCubicTo (float x1, 
                float y1, 
                float x2, 
                float y2, 
                float x3, 
                float y3)
Same as cubicTo, but the coordinates are considered relative to the current point on this contour. If there is no previous point, then a moveTo(0,0) is inserted automatically.

Parameters
x1	float
y1	float
x2	float
y2	float
x3	float
y3	float
rLineTo

Added in API level 1
void rLineTo (float dx, 
                float dy)
Same as lineTo, but the coordinates are considered relative to the last point on this contour. If there is no previous point, then a moveTo(0,0) is inserted automatically.

Parameters
dx	float: The amount to add to the x-coordinate of the previous point on this contour, to specify a line
dy	float: The amount to add to the y-coordinate of the previous point on this contour, to specify a line
rMoveTo

Added in API level 1
void rMoveTo (float dx, 
                float dy)
Set the beginning of the next contour relative to the last point on the previous contour. If there is no previous contour, this is treated the same as moveTo().

Parameters
dx	float: The amount to add to the x-coordinate of the end of the previous contour, to specify the start of a new contour
dy	float: The amount to add to the y-coordinate of the end of the previous contour, to specify the start of a new contour
rQuadTo

Added in API level 1
void rQuadTo (float dx1, 
                float dy1, 
                float dx2, 
                float dy2)
Same as quadTo, but the coordinates are considered relative to the last point on this contour. If there is no previous point, then a moveTo(0,0) is inserted automatically.

Parameters
dx1	float: The amount to add to the x-coordinate of the last point on this contour, for the control point of a quadratic curve
dy1	float: The amount to add to the y-coordinate of the last point on this contour, for the control point of a quadratic curve
dx2	float: The amount to add to the x-coordinate of the last point on this contour, for the end point of a quadratic curve
dy2	float: The amount to add to the y-coordinate of the last point on this contour, for the end point of a quadratic curve
reset

Added in API level 1
void reset ()
Clear any lines and curves from the path, making it empty. This does NOT change the fill-type setting.

rewind

Added in API level 1
void rewind ()
Rewinds the path: clears any lines and curves from the path but keeps the internal data structure for faster reuse.

set

Added in API level 1
void set (Path src)
Replace the contents of this with the contents of src.

Parameters
src	Path
setFillType

Added in API level 1
void setFillType (Path.FillType ft)
Set the path's fill type. This defines how "inside" is computed.

Parameters
ft	Path.FillType: The new fill type for this path
setLastPoint

Added in API level 1
void setLastPoint (float dx, 
                float dy)
Sets the last point of the path.

Parameters
dx	float: The new X coordinate for the last point
dy	float: The new Y coordinate for the last point
toggleInverseFillType

Added in API level 1
void toggleInverseFillType ()
Toggles the INVERSE state of the filltype

transform

Added in API level 1
void transform (Matrix matrix, 
                Path dst)
Transform the points in this path by matrix, and write the answer into dst. If dst is null, then the the original path is modified.

Parameters
matrix	Matrix: The matrix to apply to the path
dst	Path: The transformed path is written here. If dst is null, then the the original path is modified
transform

Added in API level 1
void transform (Matrix matrix)
Transform the points in this path by matrix.

Parameters
matrix	Matrix: The matrix to apply to the path
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