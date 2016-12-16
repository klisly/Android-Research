Canvas
public class Canvas 
extends Object 

java.lang.Object
   ↳	android.graphics.Canvas

The Canvas class holds the "draw" calls. To draw something, you need 4 basic components: A Bitmap to hold the pixels, a Canvas to host the draw calls (writing into the bitmap), a drawing primitive (e.g. Rect, Path, text, Bitmap), and a paint (to describe the colors and styles for the drawing).

Developer Guides
For more information about how to use Canvas, read the Canvas and Drawables developer guide.

Summary
Nested classes
enum	Canvas.EdgeType
 
enum	Canvas.VertexMode
 
Constants
int	ALL_SAVE_FLAG
Restore everything when restore() is called (standard save flags).
int	CLIP_SAVE_FLAG
Restore the current clip when restore() is called.
int	CLIP_TO_LAYER_SAVE_FLAG
Clip drawing to the bounds of the offscreen layer, omit at your own peril.
int	FULL_COLOR_LAYER_SAVE_FLAG
The layer requires full 8-bit precision for each color channel.
int	HAS_ALPHA_LAYER_SAVE_FLAG
The layer requires a per-pixel alpha channel.
int	MATRIX_SAVE_FLAG
Restore the current matrix when restore() is called.
Public constructors
Canvas()
Construct an empty raster canvas.
Canvas(Bitmap bitmap)
Construct a canvas with the specified bitmap to draw into.
Public methods
boolean	clipPath(Path path, Region.Op op)
Modify the current clip with the specified path.
boolean	clipPath(Path path)
Intersect the current clip with the specified path.
boolean	clipRect(float left, float top, float right, float bottom, Region.Op op)
Modify the current clip with the specified rectangle, which is expressed in local coordinates.
boolean	clipRect(RectF rect)
Intersect the current clip with the specified rectangle, which is expressed in local coordinates.
boolean	clipRect(Rect rect, Region.Op op)
Modify the current clip with the specified rectangle, which is expressed in local coordinates.
boolean	clipRect(int left, int top, int right, int bottom)
Intersect the current clip with the specified rectangle, which is expressed in local coordinates.
boolean	clipRect(float left, float top, float right, float bottom)
Intersect the current clip with the specified rectangle, which is expressed in local coordinates.
boolean	clipRect(RectF rect, Region.Op op)
Modify the current clip with the specified rectangle.
boolean	clipRect(Rect rect)
Intersect the current clip with the specified rectangle, which is expressed in local coordinates.
boolean	clipRegion(Region region)
This method was deprecated in API level 21. Unlike all other clip calls this API does not respect the current matrix. Use clipRect(Rect) as an alternative.
boolean	clipRegion(Region region, Region.Op op)
This method was deprecated in API level 21. Unlike all other clip calls this API does not respect the current matrix. Use clipRect(Rect) as an alternative.
void	concat(Matrix matrix)
Preconcat the current matrix with the specified matrix.
void	drawARGB(int a, int r, int g, int b)
Fill the entire canvas' bitmap (restricted to the current clip) with the specified ARGB color, using srcover porterduff mode.
void	drawArc(float left, float top, float right, float bottom, float startAngle, float sweepAngle, boolean useCenter, Paint paint)
Draw the specified arc, which will be scaled to fit inside the specified oval.
void	drawArc(RectF oval, float startAngle, float sweepAngle, boolean useCenter, Paint paint)
Draw the specified arc, which will be scaled to fit inside the specified oval.
void	drawBitmap(Bitmap bitmap, Matrix matrix, Paint paint)
Draw the bitmap using the specified matrix.
void	drawBitmap(int[] colors, int offset, int stride, float x, float y, int width, int height, boolean hasAlpha, Paint paint)
This method was deprecated in API level 21. Usage with a hardware accelerated canvas requires an internal copy of color buffer contents every time this method is called. Using a Bitmap avoids this copy, and allows the application to more explicitly control the lifetime and copies of pixel data.
void	drawBitmap(int[] colors, int offset, int stride, int x, int y, int width, int height, boolean hasAlpha, Paint paint)
This method was deprecated in API level 21. Usage with a hardware accelerated canvas requires an internal copy of color buffer contents every time this method is called. Using a Bitmap avoids this copy, and allows the application to more explicitly control the lifetime and copies of pixel data.
void	drawBitmap(Bitmap bitmap, Rect src, Rect dst, Paint paint)
Draw the specified bitmap, scaling/translating automatically to fill the destination rectangle.
void	drawBitmap(Bitmap bitmap, float left, float top, Paint paint)
Draw the specified bitmap, with its top/left corner at (x,y), using the specified paint, transformed by the current matrix.
void	drawBitmap(Bitmap bitmap, Rect src, RectF dst, Paint paint)
Draw the specified bitmap, scaling/translating automatically to fill the destination rectangle.
void	drawBitmapMesh(Bitmap bitmap, int meshWidth, int meshHeight, float[] verts, int vertOffset, int[] colors, int colorOffset, Paint paint)
Draw the bitmap through the mesh, where mesh vertices are evenly distributed across the bitmap.
void	drawCircle(float cx, float cy, float radius, Paint paint)
Draw the specified circle using the specified paint.
void	drawColor(int color)
Fill the entire canvas' bitmap (restricted to the current clip) with the specified color, using srcover porterduff mode.
void	drawColor(int color, PorterDuff.Mode mode)
Fill the entire canvas' bitmap (restricted to the current clip) with the specified color and porter-duff xfermode.
void	drawLine(float startX, float startY, float stopX, float stopY, Paint paint)
Draw a line segment with the specified start and stop x,y coordinates, using the specified paint.
void	drawLines(float[] pts, int offset, int count, Paint paint)
Draw a series of lines.
void	drawLines(float[] pts, Paint paint)
void	drawOval(float left, float top, float right, float bottom, Paint paint)
Draw the specified oval using the specified paint.
void	drawOval(RectF oval, Paint paint)
Draw the specified oval using the specified paint.
void	drawPaint(Paint paint)
Fill the entire canvas' bitmap (restricted to the current clip) with the specified paint.
void	drawPath(Path path, Paint paint)
Draw the specified path using the specified paint.
void	drawPicture(Picture picture, Rect dst)
Draw the picture, stretched to fit into the dst rectangle.
void	drawPicture(Picture picture, RectF dst)
Draw the picture, stretched to fit into the dst rectangle.
void	drawPicture(Picture picture)
Save the canvas state, draw the picture, and restore the canvas state.
void	drawPoint(float x, float y, Paint paint)
Helper for drawPoints() for drawing a single point.
void	drawPoints(float[] pts, int offset, int count, Paint paint)
Draw a series of points.
void	drawPoints(float[] pts, Paint paint)
Helper for drawPoints() that assumes you want to draw the entire array
void	drawPosText(String text, float[] pos, Paint paint)
This method was deprecated in API level 16. This method does not support glyph composition and decomposition and should therefore not be used to render complex scripts. It also doesn't handle supplementary characters (eg emoji).
void	drawPosText(char[] text, int index, int count, float[] pos, Paint paint)
This method was deprecated in API level 16. This method does not support glyph composition and decomposition and should therefore not be used to render complex scripts. It also doesn't handle supplementary characters (eg emoji).
void	drawRGB(int r, int g, int b)
Fill the entire canvas' bitmap (restricted to the current clip) with the specified RGB color, using srcover porterduff mode.
void	drawRect(float left, float top, float right, float bottom, Paint paint)
Draw the specified Rect using the specified paint.
void	drawRect(Rect r, Paint paint)
Draw the specified Rect using the specified Paint.
void	drawRect(RectF rect, Paint paint)
Draw the specified Rect using the specified paint.
void	drawRoundRect(RectF rect, float rx, float ry, Paint paint)
Draw the specified round-rect using the specified paint.
void	drawRoundRect(float left, float top, float right, float bottom, float rx, float ry, Paint paint)
Draw the specified round-rect using the specified paint.
void	drawText(CharSequence text, int start, int end, float x, float y, Paint paint)
Draw the specified range of text, specified by start/end, with its origin at (x,y), in the specified Paint.
void	drawText(String text, float x, float y, Paint paint)
Draw the text, with origin at (x,y), using the specified paint.
void	drawText(String text, int start, int end, float x, float y, Paint paint)
Draw the text, with origin at (x,y), using the specified paint.
void	drawText(char[] text, int index, int count, float x, float y, Paint paint)
Draw the text, with origin at (x,y), using the specified paint.
void	drawTextOnPath(String text, Path path, float hOffset, float vOffset, Paint paint)
Draw the text, with origin at (x,y), using the specified paint, along the specified path.
void	drawTextOnPath(char[] text, int index, int count, Path path, float hOffset, float vOffset, Paint paint)
Draw the text, with origin at (x,y), using the specified paint, along the specified path.
void	drawTextRun(char[] text, int index, int count, int contextIndex, int contextCount, float x, float y, boolean isRtl, Paint paint)
Draw a run of text, all in a single direction, with optional context for complex text shaping.
void	drawTextRun(CharSequence text, int start, int end, int contextStart, int contextEnd, float x, float y, boolean isRtl, Paint paint)
Draw a run of text, all in a single direction, with optional context for complex text shaping.
void	drawVertices(Canvas.VertexMode mode, int vertexCount, float[] verts, int vertOffset, float[] texs, int texOffset, int[] colors, int colorOffset, short[] indices, int indexOffset, int indexCount, Paint paint)
Draw the array of vertices, interpreted as triangles (based on mode).
boolean	getClipBounds(Rect bounds)
Return the bounds of the current clip (in local coordinates) in the bounds parameter, and return true if it is non-empty.
final Rect	getClipBounds()
Retrieve the bounds of the current clip (in local coordinates).
int	getDensity()
Returns the target density of the canvas.
DrawFilter	getDrawFilter()
int	getHeight()
Returns the height of the current drawing layer
final Matrix	getMatrix()
This method was deprecated in API level 16. Hardware accelerated canvases may have any matrix when passed to a View or Drawable, as it is implementation defined where in the hierarchy such canvases are created. It is recommended in such cases to either draw contents irrespective of the current matrix, or to track relevant transform state outside of the canvas.
void	getMatrix(Matrix ctm)
This method was deprecated in API level 16. Hardware accelerated canvases may have any matrix when passed to a View or Drawable, as it is implementation defined where in the hierarchy such canvases are created. It is recommended in such cases to either draw contents irrespective of the current matrix, or to track relevant transform state outside of the canvas.
int	getMaximumBitmapHeight()
Returns the maximum allowed height for bitmaps drawn with this canvas.
int	getMaximumBitmapWidth()
Returns the maximum allowed width for bitmaps drawn with this canvas.
int	getSaveCount()
Returns the number of matrix/clip states on the Canvas' private stack.
int	getWidth()
Returns the width of the current drawing layer
boolean	isHardwareAccelerated()
Indicates whether this Canvas uses hardware acceleration.
boolean	isOpaque()
Return true if the device that the current layer draws into is opaque (i.e.
boolean	quickReject(float left, float top, float right, float bottom, Canvas.EdgeType type)
Return true if the specified rectangle, after being transformed by the current matrix, would lie completely outside of the current clip.
boolean	quickReject(Path path, Canvas.EdgeType type)
Return true if the specified path, after being transformed by the current matrix, would lie completely outside of the current clip.
boolean	quickReject(RectF rect, Canvas.EdgeType type)
Return true if the specified rectangle, after being transformed by the current matrix, would lie completely outside of the current clip.
void	restore()
This call balances a previous call to save(), and is used to remove all modifications to the matrix/clip state since the last save call.
void	restoreToCount(int saveCount)
Efficient way to pop any calls to save() that happened after the save count reached saveCount.
final void	rotate(float degrees, float px, float py)
Preconcat the current matrix with the specified rotation.
void	rotate(float degrees)
Preconcat the current matrix with the specified rotation.
int	save(int saveFlags)
Based on saveFlags, can save the current matrix and clip onto a private stack.
int	save()
Saves the current matrix and clip onto a private stack.
int	saveLayer(float left, float top, float right, float bottom, Paint paint)
Convenience for saveLayer(left, top, right, bottom, paint, ALL_SAVE_FLAG)
int	saveLayer(RectF bounds, Paint paint, int saveFlags)
This behaves the same as save(), but in addition it allocates and redirects drawing to an offscreen bitmap.
int	saveLayer(RectF bounds, Paint paint)
Convenience for saveLayer(bounds, paint, ALL_SAVE_FLAG)
int	saveLayer(float left, float top, float right, float bottom, Paint paint, int saveFlags)
Helper version of saveLayer() that takes 4 values rather than a RectF.
int	saveLayerAlpha(float left, float top, float right, float bottom, int alpha, int saveFlags)
Helper for saveLayerAlpha() that takes 4 values instead of a RectF.
int	saveLayerAlpha(RectF bounds, int alpha, int saveFlags)
This behaves the same as save(), but in addition it allocates and redirects drawing to an offscreen bitmap.
int	saveLayerAlpha(float left, float top, float right, float bottom, int alpha)
Helper for saveLayerAlpha(left, top, right, bottom, alpha, ALL_SAVE_FLAG)
int	saveLayerAlpha(RectF bounds, int alpha)
Convenience for saveLayerAlpha(bounds, alpha, ALL_SAVE_FLAG)
final void	scale(float sx, float sy, float px, float py)
Preconcat the current matrix with the specified scale.
void	scale(float sx, float sy)
Preconcat the current matrix with the specified scale.
void	setBitmap(Bitmap bitmap)
Specify a bitmap for the canvas to draw into.
void	setDensity(int density)
Specifies the density for this Canvas' backing bitmap.
void	setDrawFilter(DrawFilter filter)
void	setMatrix(Matrix matrix)
Completely replace the current matrix with the specified matrix.
void	skew(float sx, float sy)
Preconcat the current matrix with the specified skew.
void	translate(float dx, float dy)
Preconcat the current matrix with the specified translation
Inherited methods
From class java.lang.Object
Constants
ALL_SAVE_FLAG

Added in API level 1
int ALL_SAVE_FLAG
Restore everything when restore() is called (standard save flags).

Note: for performance reasons, it is strongly recommended to pass this - the complete set of flags - to any call to saveLayer() and saveLayerAlpha() variants.

Constant Value: 31 (0x0000001f)

CLIP_SAVE_FLAG

Added in API level 1
int CLIP_SAVE_FLAG
Restore the current clip when restore() is called.

Constant Value: 2 (0x00000002)

CLIP_TO_LAYER_SAVE_FLAG

Added in API level 1
int CLIP_TO_LAYER_SAVE_FLAG
Clip drawing to the bounds of the offscreen layer, omit at your own peril.

Note: it is strongly recommended to not omit this flag for any call to saveLayer() and saveLayerAlpha() variants. Not passing this flag generally triggers extremely poor performance with hardware accelerated rendering.

Constant Value: 16 (0x00000010)

FULL_COLOR_LAYER_SAVE_FLAG

Added in API level 1
int FULL_COLOR_LAYER_SAVE_FLAG
The layer requires full 8-bit precision for each color channel.

Constant Value: 8 (0x00000008)

HAS_ALPHA_LAYER_SAVE_FLAG

Added in API level 1
int HAS_ALPHA_LAYER_SAVE_FLAG
The layer requires a per-pixel alpha channel.

Constant Value: 4 (0x00000004)

MATRIX_SAVE_FLAG

Added in API level 1
int MATRIX_SAVE_FLAG
Restore the current matrix when restore() is called.

Constant Value: 1 (0x00000001)

Public constructors
Canvas

Added in API level 1
Canvas ()
Construct an empty raster canvas. Use setBitmap() to specify a bitmap to draw into. The initial target density is DENSITY_NONE; this will typically be replaced when a target bitmap is set for the canvas.

Canvas

Added in API level 1
Canvas (Bitmap bitmap)
Construct a canvas with the specified bitmap to draw into. The bitmap must be mutable.

The initial target density of the canvas is the same as the given bitmap's density.

Parameters
bitmap	Bitmap: Specifies a mutable bitmap for the canvas to draw into.
Public methods
clipPath

Added in API level 1
boolean clipPath (Path path, 
                Region.Op op)
Modify the current clip with the specified path.

Parameters
path	Path: The path to operate on the current clip
op	Region.Op: How the clip is modified
Returns
boolean	true if the resulting is non-empty
clipPath

Added in API level 1
boolean clipPath (Path path)
Intersect the current clip with the specified path.

Parameters
path	Path: The path to intersect with the current clip
Returns
boolean	true if the resulting is non-empty
clipRect

Added in API level 1
boolean clipRect (float left, 
                float top, 
                float right, 
                float bottom, 
                Region.Op op)
Modify the current clip with the specified rectangle, which is expressed in local coordinates.

Parameters
left	float: The left side of the rectangle to intersect with the current clip
top	float: The top of the rectangle to intersect with the current clip
right	float: The right side of the rectangle to intersect with the current clip
bottom	float: The bottom of the rectangle to intersect with the current clip
op	Region.Op: How the clip is modified
Returns
boolean	true if the resulting clip is non-empty
clipRect

Added in API level 1
boolean clipRect (RectF rect)
Intersect the current clip with the specified rectangle, which is expressed in local coordinates.

Parameters
rect	RectF: The rectangle to intersect with the current clip.
Returns
boolean	true if the resulting clip is non-empty
clipRect

Added in API level 1
boolean clipRect (Rect rect, 
                Region.Op op)
Modify the current clip with the specified rectangle, which is expressed in local coordinates.

Parameters
rect	Rect: The rectangle to intersect with the current clip.
op	Region.Op: How the clip is modified
Returns
boolean	true if the resulting clip is non-empty
clipRect

Added in API level 1
boolean clipRect (int left, 
                int top, 
                int right, 
                int bottom)
Intersect the current clip with the specified rectangle, which is expressed in local coordinates.

Parameters
left	int: The left side of the rectangle to intersect with the current clip
top	int: The top of the rectangle to intersect with the current clip
right	int: The right side of the rectangle to intersect with the current clip
bottom	int: The bottom of the rectangle to intersect with the current clip
Returns
boolean	true if the resulting clip is non-empty
clipRect

Added in API level 1
boolean clipRect (float left, 
                float top, 
                float right, 
                float bottom)
Intersect the current clip with the specified rectangle, which is expressed in local coordinates.

Parameters
left	float: The left side of the rectangle to intersect with the current clip
top	float: The top of the rectangle to intersect with the current clip
right	float: The right side of the rectangle to intersect with the current clip
bottom	float: The bottom of the rectangle to intersect with the current clip
Returns
boolean	true if the resulting clip is non-empty
clipRect

Added in API level 1
boolean clipRect (RectF rect, 
                Region.Op op)
Modify the current clip with the specified rectangle.

Parameters
rect	RectF: The rect to intersect with the current clip
op	Region.Op: How the clip is modified
Returns
boolean	true if the resulting clip is non-empty
clipRect

Added in API level 1
boolean clipRect (Rect rect)
Intersect the current clip with the specified rectangle, which is expressed in local coordinates.

Parameters
rect	Rect: The rectangle to intersect with the current clip.
Returns
boolean	true if the resulting clip is non-empty
clipRegion

Added in API level 1
boolean clipRegion (Region region)
This method was deprecated in API level 21.
Unlike all other clip calls this API does not respect the current matrix. Use clipRect(Rect) as an alternative.

Intersect the current clip with the specified region. Note that unlike clipRect() and clipPath() which transform their arguments by the current matrix, clipRegion() assumes its argument is already in the coordinate system of the current layer's bitmap, and so not transformation is performed.

Parameters
region	Region: The region to operate on the current clip, based on op
Returns
boolean	true if the resulting is non-empty
clipRegion

Added in API level 1
boolean clipRegion (Region region, 
                Region.Op op)
This method was deprecated in API level 21.
Unlike all other clip calls this API does not respect the current matrix. Use clipRect(Rect) as an alternative.

Modify the current clip with the specified region. Note that unlike clipRect() and clipPath() which transform their arguments by the current matrix, clipRegion() assumes its argument is already in the coordinate system of the current layer's bitmap, and so not transformation is performed.

Parameters
region	Region: The region to operate on the current clip, based on op
op	Region.Op: How the clip is modified
Returns
boolean	true if the resulting is non-empty
concat

Added in API level 1
void concat (Matrix matrix)
Preconcat the current matrix with the specified matrix. If the specified matrix is null, this method does nothing.

Parameters
matrix	Matrix: The matrix to preconcatenate with the current matrix
drawARGB

Added in API level 1
void drawARGB (int a, 
                int r, 
                int g, 
                int b)
Fill the entire canvas' bitmap (restricted to the current clip) with the specified ARGB color, using srcover porterduff mode.

Parameters
a	int: alpha component (0..255) of the color to draw onto the canvas
r	int: red component (0..255) of the color to draw onto the canvas
g	int: green component (0..255) of the color to draw onto the canvas
b	int: blue component (0..255) of the color to draw onto the canvas
drawArc

Added in API level 21
void drawArc (float left, 
                float top, 
                float right, 
                float bottom, 
                float startAngle, 
                float sweepAngle, 
                boolean useCenter, 
                Paint paint)
Draw the specified arc, which will be scaled to fit inside the specified oval.

If the start angle is negative or >= 360, the start angle is treated as start angle modulo 360.

If the sweep angle is >= 360, then the oval is drawn completely. Note that this differs slightly from SkPath::arcTo, which treats the sweep angle modulo 360. If the sweep angle is negative, the sweep angle is treated as sweep angle modulo 360

The arc is drawn clockwise. An angle of 0 degrees correspond to the geometric angle of 0 degrees (3 o'clock on a watch.)

Parameters
left	float
top	float
right	float
bottom	float
startAngle	float: Starting angle (in degrees) where the arc begins
sweepAngle	float: Sweep angle (in degrees) measured clockwise
useCenter	boolean: If true, include the center of the oval in the arc, and close it if it is being stroked. This will draw a wedge
paint	Paint: The paint used to draw the arc
drawArc

Added in API level 1
void drawArc (RectF oval, 
                float startAngle, 
                float sweepAngle, 
                boolean useCenter, 
                Paint paint)
Draw the specified arc, which will be scaled to fit inside the specified oval.

If the start angle is negative or >= 360, the start angle is treated as start angle modulo 360.

If the sweep angle is >= 360, then the oval is drawn completely. Note that this differs slightly from SkPath::arcTo, which treats the sweep angle modulo 360. If the sweep angle is negative, the sweep angle is treated as sweep angle modulo 360

The arc is drawn clockwise. An angle of 0 degrees correspond to the geometric angle of 0 degrees (3 o'clock on a watch.)

Parameters
oval	RectF: The bounds of oval used to define the shape and size of the arc
startAngle	float: Starting angle (in degrees) where the arc begins
sweepAngle	float: Sweep angle (in degrees) measured clockwise
useCenter	boolean: If true, include the center of the oval in the arc, and close it if it is being stroked. This will draw a wedge
paint	Paint: The paint used to draw the arc
drawBitmap

Added in API level 1
void drawBitmap (Bitmap bitmap, 
                Matrix matrix, 
                Paint paint)
Draw the bitmap using the specified matrix.

Parameters
bitmap	Bitmap: The bitmap to draw
matrix	Matrix: The matrix used to transform the bitmap when it is drawn
paint	Paint: May be null. The paint used to draw the bitmap
drawBitmap

Added in API level 3
void drawBitmap (int[] colors, 
                int offset, 
                int stride, 
                float x, 
                float y, 
                int width, 
                int height, 
                boolean hasAlpha, 
                Paint paint)
This method was deprecated in API level 21.
Usage with a hardware accelerated canvas requires an internal copy of color buffer contents every time this method is called. Using a Bitmap avoids this copy, and allows the application to more explicitly control the lifetime and copies of pixel data.

Treat the specified array of colors as a bitmap, and draw it. This gives the same result as first creating a bitmap from the array, and then drawing it, but this method avoids explicitly creating a bitmap object which can be more efficient if the colors are changing often.

Parameters
colors	int: Array of colors representing the pixels of the bitmap
offset	int: Offset into the array of colors for the first pixel
stride	int: The number of colors in the array between rows (must be >= width or <= -width).
x	float: The X coordinate for where to draw the bitmap
y	float: The Y coordinate for where to draw the bitmap
width	int: The width of the bitmap
height	int: The height of the bitmap
hasAlpha	boolean: True if the alpha channel of the colors contains valid values. If false, the alpha byte is ignored (assumed to be 0xFF for every pixel).
paint	Paint: May be null. The paint used to draw the bitmap
drawBitmap

Added in API level 1
void drawBitmap (int[] colors, 
                int offset, 
                int stride, 
                int x, 
                int y, 
                int width, 
                int height, 
                boolean hasAlpha, 
                Paint paint)
This method was deprecated in API level 21.
Usage with a hardware accelerated canvas requires an internal copy of color buffer contents every time this method is called. Using a Bitmap avoids this copy, and allows the application to more explicitly control the lifetime and copies of pixel data.

Legacy version of drawBitmap(int[] colors, ...) that took ints for x,y

Parameters
colors	int
offset	int
stride	int
x	int
y	int
width	int
height	int
hasAlpha	boolean
paint	Paint
drawBitmap

Added in API level 1
void drawBitmap (Bitmap bitmap, 
                Rect src, 
                Rect dst, 
                Paint paint)
Draw the specified bitmap, scaling/translating automatically to fill the destination rectangle. If the source rectangle is not null, it specifies the subset of the bitmap to draw.

Note: if the paint contains a maskfilter that generates a mask which extends beyond the bitmap's original width/height (e.g. BlurMaskFilter), then the bitmap will be drawn as if it were in a Shader with CLAMP mode. Thus the color outside of the original width/height will be the edge color replicated.

This function ignores the density associated with the bitmap. This is because the source and destination rectangle coordinate spaces are in their respective densities, so must already have the appropriate scaling factor applied.

Parameters
bitmap	Bitmap: The bitmap to be drawn
src	Rect: May be null. The subset of the bitmap to be drawn
dst	Rect: The rectangle that the bitmap will be scaled/translated to fit into
paint	Paint: May be null. The paint used to draw the bitmap
drawBitmap

Added in API level 1
void drawBitmap (Bitmap bitmap, 
                float left, 
                float top, 
                Paint paint)
Draw the specified bitmap, with its top/left corner at (x,y), using the specified paint, transformed by the current matrix.

Note: if the paint contains a maskfilter that generates a mask which extends beyond the bitmap's original width/height (e.g. BlurMaskFilter), then the bitmap will be drawn as if it were in a Shader with CLAMP mode. Thus the color outside of the original width/height will be the edge color replicated.

If the bitmap and canvas have different densities, this function will take care of automatically scaling the bitmap to draw at the same density as the canvas.

Parameters
bitmap	Bitmap: The bitmap to be drawn
left	float: The position of the left side of the bitmap being drawn
top	float: The position of the top side of the bitmap being drawn
paint	Paint: The paint used to draw the bitmap (may be null)
drawBitmap

Added in API level 1
void drawBitmap (Bitmap bitmap, 
                Rect src, 
                RectF dst, 
                Paint paint)
Draw the specified bitmap, scaling/translating automatically to fill the destination rectangle. If the source rectangle is not null, it specifies the subset of the bitmap to draw.

Note: if the paint contains a maskfilter that generates a mask which extends beyond the bitmap's original width/height (e.g. BlurMaskFilter), then the bitmap will be drawn as if it were in a Shader with CLAMP mode. Thus the color outside of the original width/height will be the edge color replicated.

This function ignores the density associated with the bitmap. This is because the source and destination rectangle coordinate spaces are in their respective densities, so must already have the appropriate scaling factor applied.

Parameters
bitmap	Bitmap: The bitmap to be drawn
src	Rect: May be null. The subset of the bitmap to be drawn
dst	RectF: The rectangle that the bitmap will be scaled/translated to fit into
paint	Paint: May be null. The paint used to draw the bitmap
drawBitmapMesh

Added in API level 1
void drawBitmapMesh (Bitmap bitmap, 
                int meshWidth, 
                int meshHeight, 
                float[] verts, 
                int vertOffset, 
                int[] colors, 
                int colorOffset, 
                Paint paint)
Draw the bitmap through the mesh, where mesh vertices are evenly distributed across the bitmap. There are meshWidth+1 vertices across, and meshHeight+1 vertices down. The verts array is accessed in row-major order, so that the first meshWidth+1 vertices are distributed across the top of the bitmap from left to right. A more general version of this method is drawVertices().

Parameters
bitmap	Bitmap: The bitmap to draw using the mesh
meshWidth	int: The number of columns in the mesh. Nothing is drawn if this is 0
meshHeight	int: The number of rows in the mesh. Nothing is drawn if this is 0
verts	float: Array of x,y pairs, specifying where the mesh should be drawn. There must be at least (meshWidth+1) * (meshHeight+1) * 2 + vertOffset values in the array
vertOffset	int: Number of verts elements to skip before drawing
colors	int: May be null. Specifies a color at each vertex, which is interpolated across the cell, and whose values are multiplied by the corresponding bitmap colors. If not null, there must be at least (meshWidth+1) * (meshHeight+1) + colorOffset values in the array.
colorOffset	int: Number of color elements to skip before drawing
paint	Paint: May be null. The paint used to draw the bitmap
drawCircle

Added in API level 1
void drawCircle (float cx, 
                float cy, 
                float radius, 
                Paint paint)
Draw the specified circle using the specified paint. If radius is <= 0, then nothing will be drawn. The circle will be filled or framed based on the Style in the paint.

Parameters
cx	float: The x-coordinate of the center of the cirle to be drawn
cy	float: The y-coordinate of the center of the cirle to be drawn
radius	float: The radius of the cirle to be drawn
paint	Paint: The paint used to draw the circle
drawColor

Added in API level 1
void drawColor (int color)
Fill the entire canvas' bitmap (restricted to the current clip) with the specified color, using srcover porterduff mode.

Parameters
color	int: the color to draw onto the canvas
drawColor

Added in API level 1
void drawColor (int color, 
                PorterDuff.Mode mode)
Fill the entire canvas' bitmap (restricted to the current clip) with the specified color and porter-duff xfermode.

Parameters
color	int: the color to draw with
mode	PorterDuff.Mode: the porter-duff mode to apply to the color
drawLine

Added in API level 1
void drawLine (float startX, 
                float startY, 
                float stopX, 
                float stopY, 
                Paint paint)
Draw a line segment with the specified start and stop x,y coordinates, using the specified paint.

Note that since a line is always "framed", the Style is ignored in the paint.

Degenerate lines (length is 0) will not be drawn.

Parameters
startX	float: The x-coordinate of the start point of the line
startY	float: The y-coordinate of the start point of the line
stopX	float
stopY	float
paint	Paint: The paint used to draw the line
drawLines

Added in API level 1
void drawLines (float[] pts, 
                int offset, 
                int count, 
                Paint paint)
Draw a series of lines. Each line is taken from 4 consecutive values in the pts array. Thus to draw 1 line, the array must contain at least 4 values. This is logically the same as drawing the array as follows: drawLine(pts[0], pts[1], pts[2], pts[3]) followed by drawLine(pts[4], pts[5], pts[6], pts[7]) and so on.

Parameters
pts	float: Array of points to draw [x0 y0 x1 y1 x2 y2 ...]
offset	int: Number of values in the array to skip before drawing.
count	int: The number of values in the array to process, after skipping "offset" of them. Since each line uses 4 values, the number of "lines" that are drawn is really (count >> 2).
paint	Paint: The paint used to draw the points
drawLines

Added in API level 1
void drawLines (float[] pts, 
                Paint paint)
Parameters
pts	float
paint	Paint
drawOval

Added in API level 21
void drawOval (float left, 
                float top, 
                float right, 
                float bottom, 
                Paint paint)
Draw the specified oval using the specified paint. The oval will be filled or framed based on the Style in the paint.

Parameters
left	float
top	float
right	float
bottom	float
paint	Paint
drawOval

Added in API level 1
void drawOval (RectF oval, 
                Paint paint)
Draw the specified oval using the specified paint. The oval will be filled or framed based on the Style in the paint.

Parameters
oval	RectF: The rectangle bounds of the oval to be drawn
paint	Paint
drawPaint

Added in API level 1
void drawPaint (Paint paint)
Fill the entire canvas' bitmap (restricted to the current clip) with the specified paint. This is equivalent (but faster) to drawing an infinitely large rectangle with the specified paint.

Parameters
paint	Paint: The paint used to draw onto the canvas
drawPath

Added in API level 1
void drawPath (Path path, 
                Paint paint)
Draw the specified path using the specified paint. The path will be filled or framed based on the Style in the paint.

Parameters
path	Path: The path to be drawn
paint	Paint: The paint used to draw the path
drawPicture

Added in API level 1
void drawPicture (Picture picture, 
                Rect dst)
Draw the picture, stretched to fit into the dst rectangle.

Parameters
picture	Picture
dst	Rect
drawPicture

Added in API level 1
void drawPicture (Picture picture, 
                RectF dst)
Draw the picture, stretched to fit into the dst rectangle.

Parameters
picture	Picture
dst	RectF
drawPicture

Added in API level 1
void drawPicture (Picture picture)
Save the canvas state, draw the picture, and restore the canvas state. This differs from picture.draw(canvas), which does not perform any save/restore.

Note: This forces the picture to internally call endRecording() in order to prepare for playback.

Parameters
picture	Picture: The picture to be drawn
drawPoint

Added in API level 1
void drawPoint (float x, 
                float y, 
                Paint paint)
Helper for drawPoints() for drawing a single point.

Parameters
x	float
y	float
paint	Paint
drawPoints

Added in API level 1
void drawPoints (float[] pts, 
                int offset, 
                int count, 
                Paint paint)
Draw a series of points. Each point is centered at the coordinate specified by pts[], and its diameter is specified by the paint's stroke width (as transformed by the canvas' CTM), with special treatment for a stroke width of 0, which always draws exactly 1 pixel (or at most 4 if antialiasing is enabled). The shape of the point is controlled by the paint's Cap type. The shape is a square, unless the cap type is Round, in which case the shape is a circle.

Parameters
pts	float: Array of points to draw [x0 y0 x1 y1 x2 y2 ...]
offset	int: Number of values to skip before starting to draw.
count	int: The number of values to process, after skipping offset of them. Since one point uses two values, the number of "points" that are drawn is really (count >> 1).
paint	Paint: The paint used to draw the points
drawPoints

Added in API level 1
void drawPoints (float[] pts, 
                Paint paint)
Helper for drawPoints() that assumes you want to draw the entire array

Parameters
pts	float
paint	Paint
drawPosText

Added in API level 1
void drawPosText (String text, 
                float[] pos, 
                Paint paint)
This method was deprecated in API level 16.
This method does not support glyph composition and decomposition and should therefore not be used to render complex scripts. It also doesn't handle supplementary characters (eg emoji).

Draw the text in the array, with each character's origin specified by the pos array.

Parameters
text	String: The text to be drawn
pos	float: Array of [x,y] positions, used to position each character
paint	Paint: The paint used for the text (e.g. color, size, style)
drawPosText

Added in API level 1
void drawPosText (char[] text, 
                int index, 
                int count, 
                float[] pos, 
                Paint paint)
This method was deprecated in API level 16.
This method does not support glyph composition and decomposition and should therefore not be used to render complex scripts. It also doesn't handle supplementary characters (eg emoji).

Draw the text in the array, with each character's origin specified by the pos array.

Parameters
text	char: The text to be drawn
index	int: The index of the first character to draw
count	int: The number of characters to draw, starting from index.
pos	float: Array of [x,y] positions, used to position each character
paint	Paint: The paint used for the text (e.g. color, size, style)
drawRGB

Added in API level 1
void drawRGB (int r, 
                int g, 
                int b)
Fill the entire canvas' bitmap (restricted to the current clip) with the specified RGB color, using srcover porterduff mode.

Parameters
r	int: red component (0..255) of the color to draw onto the canvas
g	int: green component (0..255) of the color to draw onto the canvas
b	int: blue component (0..255) of the color to draw onto the canvas
drawRect

Added in API level 1
void drawRect (float left, 
                float top, 
                float right, 
                float bottom, 
                Paint paint)
Draw the specified Rect using the specified paint. The rectangle will be filled or framed based on the Style in the paint.

Parameters
left	float: The left side of the rectangle to be drawn
top	float: The top side of the rectangle to be drawn
right	float: The right side of the rectangle to be drawn
bottom	float: The bottom side of the rectangle to be drawn
paint	Paint: The paint used to draw the rect
drawRect

Added in API level 1
void drawRect (Rect r, 
                Paint paint)
Draw the specified Rect using the specified Paint. The rectangle will be filled or framed based on the Style in the paint.

Parameters
r	Rect: The rectangle to be drawn.
paint	Paint: The paint used to draw the rectangle
drawRect

Added in API level 1
void drawRect (RectF rect, 
                Paint paint)
Draw the specified Rect using the specified paint. The rectangle will be filled or framed based on the Style in the paint.

Parameters
rect	RectF: The rect to be drawn
paint	Paint: The paint used to draw the rect
drawRoundRect

Added in API level 1
void drawRoundRect (RectF rect, 
                float rx, 
                float ry, 
                Paint paint)
Draw the specified round-rect using the specified paint. The roundrect will be filled or framed based on the Style in the paint.

Parameters
rect	RectF: The rectangular bounds of the roundRect to be drawn
rx	float: The x-radius of the oval used to round the corners
ry	float: The y-radius of the oval used to round the corners
paint	Paint: The paint used to draw the roundRect
drawRoundRect

Added in API level 21
void drawRoundRect (float left, 
                float top, 
                float right, 
                float bottom, 
                float rx, 
                float ry, 
                Paint paint)
Draw the specified round-rect using the specified paint. The roundrect will be filled or framed based on the Style in the paint.

Parameters
left	float
top	float
right	float
bottom	float
rx	float: The x-radius of the oval used to round the corners
ry	float: The y-radius of the oval used to round the corners
paint	Paint: The paint used to draw the roundRect
drawText

Added in API level 1
void drawText (CharSequence text, 
                int start, 
                int end, 
                float x, 
                float y, 
                Paint paint)
Draw the specified range of text, specified by start/end, with its origin at (x,y), in the specified Paint. The origin is interpreted based on the Align setting in the Paint.

Parameters
text	CharSequence: The text to be drawn
start	int: The index of the first character in text to draw
end	int: (end - 1) is the index of the last character in text to draw
x	float: The x-coordinate of origin for where to draw the text
y	float: The y-coordinate of origin for where to draw the text
paint	Paint: The paint used for the text (e.g. color, size, style)
drawText

Added in API level 1
void drawText (String text, 
                float x, 
                float y, 
                Paint paint)
Draw the text, with origin at (x,y), using the specified paint. The origin is interpreted based on the Align setting in the paint.

Parameters
text	String: The text to be drawn
x	float: The x-coordinate of the origin of the text being drawn
y	float: The y-coordinate of the baseline of the text being drawn
paint	Paint: The paint used for the text (e.g. color, size, style)
drawText

Added in API level 1
void drawText (String text, 
                int start, 
                int end, 
                float x, 
                float y, 
                Paint paint)
Draw the text, with origin at (x,y), using the specified paint. The origin is interpreted based on the Align setting in the paint.

Parameters
text	String: The text to be drawn
start	int: The index of the first character in text to draw
end	int: (end - 1) is the index of the last character in text to draw
x	float: The x-coordinate of the origin of the text being drawn
y	float: The y-coordinate of the baseline of the text being drawn
paint	Paint: The paint used for the text (e.g. color, size, style)
drawText

Added in API level 1
void drawText (char[] text, 
                int index, 
                int count, 
                float x, 
                float y, 
                Paint paint)
Draw the text, with origin at (x,y), using the specified paint. The origin is interpreted based on the Align setting in the paint.

Parameters
text	char: The text to be drawn
index	int
count	int
x	float: The x-coordinate of the origin of the text being drawn
y	float: The y-coordinate of the baseline of the text being drawn
paint	Paint: The paint used for the text (e.g. color, size, style)
drawTextOnPath

Added in API level 1
void drawTextOnPath (String text, 
                Path path, 
                float hOffset, 
                float vOffset, 
                Paint paint)
Draw the text, with origin at (x,y), using the specified paint, along the specified path. The paint's Align setting determins where along the path to start the text.

Parameters
text	String: The text to be drawn
path	Path: The path the text should follow for its baseline
hOffset	float: The distance along the path to add to the text's starting position
vOffset	float: The distance above(-) or below(+) the path to position the text
paint	Paint: The paint used for the text (e.g. color, size, style)
drawTextOnPath

Added in API level 1
void drawTextOnPath (char[] text, 
                int index, 
                int count, 
                Path path, 
                float hOffset, 
                float vOffset, 
                Paint paint)
Draw the text, with origin at (x,y), using the specified paint, along the specified path. The paint's Align setting determins where along the path to start the text.

Parameters
text	char: The text to be drawn
index	int
count	int
path	Path: The path the text should follow for its baseline
hOffset	float: The distance along the path to add to the text's starting position
vOffset	float: The distance above(-) or below(+) the path to position the text
paint	Paint: The paint used for the text (e.g. color, size, style)
drawTextRun

Added in API level 23
void drawTextRun (char[] text, 
                int index, 
                int count, 
                int contextIndex, 
                int contextCount, 
                float x, 
                float y, 
                boolean isRtl, 
                Paint paint)
Draw a run of text, all in a single direction, with optional context for complex text shaping.

See drawTextRun(CharSequence, int, int, int, int, float, float, boolean, Paint) for more details. This method uses a character array rather than CharSequence to represent the string. Also, to be consistent with the pattern established in drawText(char[], int, int, float, float, Paint), in this method count and contextCount are used rather than offsets of the end position; count = end - start, contextCount = contextEnd - contextStart.

Parameters
text	char: the text to render
index	int: the start of the text to render
count	int: the count of chars to render
contextIndex	int: the start of the context for shaping. Must be no greater than index.
contextCount	int: the number of characters in the context for shaping. contexIndex + contextCount must be no less than index + count.
x	float: the x position at which to draw the text
y	float: the y position at which to draw the text
isRtl	boolean: whether the run is in RTL direction
paint	Paint: the paint
drawTextRun

Added in API level 23
void drawTextRun (CharSequence text, 
                int start, 
                int end, 
                int contextStart, 
                int contextEnd, 
                float x, 
                float y, 
                boolean isRtl, 
                Paint paint)
Draw a run of text, all in a single direction, with optional context for complex text shaping.

The run of text includes the characters from start to end in the text. In addition, the range contextStart to contextEnd is used as context for the purpose of complex text shaping, such as Arabic text potentially shaped differently based on the text next to it.

All text outside the range contextStart..contextEnd is ignored. The text between start and end will be laid out and drawn.

The direction of the run is explicitly specified by isRtl. Thus, this method is suitable only for runs of a single direction. Alignment of the text is as determined by the Paint's TextAlign value. Further, 0 <= contextStart <= start <= end <= contextEnd <= text.length must hold on entry.

Also see getRunAdvance(char[], int, int, int, int, boolean, int) for a corresponding method to measure the text; the advance width of the text drawn matches the value obtained from that method.

Parameters
text	CharSequence: the text to render
start	int: the start of the text to render. Data before this position can be used for shaping context.
end	int: the end of the text to render. Data at or after this position can be used for shaping context.
contextStart	int: the index of the start of the shaping context
contextEnd	int: the index of the end of the shaping context
x	float: the x position at which to draw the text
y	float: the y position at which to draw the text
isRtl	boolean: whether the run is in RTL direction
paint	Paint: the paint
See also:

drawTextRun(char[], int, int, int, int, float, float, boolean, Paint)
drawVertices

Added in API level 1
void drawVertices (Canvas.VertexMode mode, 
                int vertexCount, 
                float[] verts, 
                int vertOffset, 
                float[] texs, 
                int texOffset, 
                int[] colors, 
                int colorOffset, 
                short[] indices, 
                int indexOffset, 
                int indexCount, 
                Paint paint)
Draw the array of vertices, interpreted as triangles (based on mode). The verts array is required, and specifies the x,y pairs for each vertex. If texs is non-null, then it is used to specify the coordinate in shader coordinates to use at each vertex (the paint must have a shader in this case). If there is no texs array, but there is a color array, then each color is interpolated across its corresponding triangle in a gradient. If both texs and colors arrays are present, then they behave as before, but the resulting color at each pixels is the result of multiplying the colors from the shader and the color-gradient together. The indices array is optional, but if it is present, then it is used to specify the index of each triangle, rather than just walking through the arrays in order.

Parameters
mode	Canvas.VertexMode: How to interpret the array of vertices
vertexCount	int: The number of values in the vertices array (and corresponding texs and colors arrays if non-null). Each logical vertex is two values (x, y), vertexCount must be a multiple of 2.
verts	float: Array of vertices for the mesh
vertOffset	int: Number of values in the verts to skip before drawing.
texs	float: May be null. If not null, specifies the coordinates to sample into the current shader (e.g. bitmap tile or gradient)
texOffset	int: Number of values in texs to skip before drawing.
colors	int: May be null. If not null, specifies a color for each vertex, to be interpolated across the triangle.
colorOffset	int: Number of values in colors to skip before drawing.
indices	short: If not null, array of indices to reference into the vertex (texs, colors) array.
indexOffset	int
indexCount	int: number of entries in the indices array (if not null).
paint	Paint: Specifies the shader to use if the texs array is non-null.
getClipBounds

Added in API level 1
boolean getClipBounds (Rect bounds)
Return the bounds of the current clip (in local coordinates) in the bounds parameter, and return true if it is non-empty. This can be useful in a way similar to quickReject, in that it tells you that drawing outside of these bounds will be clipped out.

Parameters
bounds	Rect: Return the clip bounds here. If it is null, ignore it but still return true if the current clip is non-empty.
Returns
boolean	true if the current clip is non-empty.
getClipBounds

Added in API level 1
Rect getClipBounds ()
Retrieve the bounds of the current clip (in local coordinates).

Returns
Rect	the clip bounds, or [0, 0, 0, 0] if the clip is empty.
getDensity

Added in API level 4
int getDensity ()
Returns the target density of the canvas. The default density is derived from the density of its backing bitmap, or DENSITY_NONE if there is not one.

Returns
int	Returns the current target density of the canvas, which is used to determine the scaling factor when drawing a bitmap into it.
See also:

setDensity(int)
getDensity()
getDrawFilter

Added in API level 1
DrawFilter getDrawFilter ()
Returns
DrawFilter	
getHeight

Added in API level 1
int getHeight ()
Returns the height of the current drawing layer

Returns
int	the height of the current drawing layer
getMatrix

Added in API level 1
Matrix getMatrix ()
This method was deprecated in API level 16.
Hardware accelerated canvases may have any matrix when passed to a View or Drawable, as it is implementation defined where in the hierarchy such canvases are created. It is recommended in such cases to either draw contents irrespective of the current matrix, or to track relevant transform state outside of the canvas.

Return a new matrix with a copy of the canvas' current transformation matrix.

Returns
Matrix	
getMatrix

Added in API level 1
void getMatrix (Matrix ctm)
This method was deprecated in API level 16.
Hardware accelerated canvases may have any matrix when passed to a View or Drawable, as it is implementation defined where in the hierarchy such canvases are created. It is recommended in such cases to either draw contents irrespective of the current matrix, or to track relevant transform state outside of the canvas.

Return, in ctm, the current transformation matrix. This does not alter the matrix in the canvas, but just returns a copy of it.

Parameters
ctm	Matrix
getMaximumBitmapHeight

Added in API level 14
int getMaximumBitmapHeight ()
Returns the maximum allowed height for bitmaps drawn with this canvas. Attempting to draw with a bitmap taller than this value will result in an error.

Returns
int	
See also:

getMaximumBitmapWidth()
getMaximumBitmapWidth

Added in API level 14
int getMaximumBitmapWidth ()
Returns the maximum allowed width for bitmaps drawn with this canvas. Attempting to draw with a bitmap wider than this value will result in an error.

Returns
int	
See also:

getMaximumBitmapHeight()
getSaveCount

Added in API level 1
int getSaveCount ()
Returns the number of matrix/clip states on the Canvas' private stack. This will equal # save() calls - # restore() calls.

Returns
int	
getWidth

Added in API level 1
int getWidth ()
Returns the width of the current drawing layer

Returns
int	the width of the current drawing layer
isHardwareAccelerated

Added in API level 11
boolean isHardwareAccelerated ()
Indicates whether this Canvas uses hardware acceleration. Note that this method does not define what type of hardware acceleration may or may not be used.

Returns
boolean	True if drawing operations are hardware accelerated, false otherwise.
isOpaque

Added in API level 1
boolean isOpaque ()
Return true if the device that the current layer draws into is opaque (i.e. does not support per-pixel alpha).

Returns
boolean	true if the device that the current layer draws into is opaque
quickReject

Added in API level 1
boolean quickReject (float left, 
                float top, 
                float right, 
                float bottom, 
                Canvas.EdgeType type)
Return true if the specified rectangle, after being transformed by the current matrix, would lie completely outside of the current clip. Call this to check if an area you intend to draw into is clipped out (and therefore you can skip making the draw calls).

Parameters
left	float: The left side of the rectangle to compare with the current clip
top	float: The top of the rectangle to compare with the current clip
right	float: The right side of the rectangle to compare with the current clip
bottom	float: The bottom of the rectangle to compare with the current clip
type	Canvas.EdgeType: AA if the path should be considered antialiased, since that means it may affect a larger area (more pixels) than non-antialiased (BW).
Returns
boolean	true if the rect (transformed by the canvas' matrix) does not intersect with the canvas' clip
quickReject

Added in API level 1
boolean quickReject (Path path, 
                Canvas.EdgeType type)
Return true if the specified path, after being transformed by the current matrix, would lie completely outside of the current clip. Call this to check if an area you intend to draw into is clipped out (and therefore you can skip making the draw calls). Note: for speed it may return false even if the path itself might not intersect the clip (i.e. the bounds of the path intersects, but the path does not).

Parameters
path	Path: The path to compare with the current clip
type	Canvas.EdgeType: AA if the path should be considered antialiased, since that means it may affect a larger area (more pixels) than non-antialiased (BW).
Returns
boolean	true if the path (transformed by the canvas' matrix) does not intersect with the canvas' clip
quickReject

Added in API level 1
boolean quickReject (RectF rect, 
                Canvas.EdgeType type)
Return true if the specified rectangle, after being transformed by the current matrix, would lie completely outside of the current clip. Call this to check if an area you intend to draw into is clipped out (and therefore you can skip making the draw calls).

Parameters
rect	RectF: the rect to compare with the current clip
type	Canvas.EdgeType: AA if the path should be considered antialiased, since that means it may affect a larger area (more pixels) than non-antialiased (BW).
Returns
boolean	true if the rect (transformed by the canvas' matrix) does not intersect with the canvas' clip
restore

Added in API level 1
void restore ()
This call balances a previous call to save(), and is used to remove all modifications to the matrix/clip state since the last save call. It is an error to call restore() more times than save() was called.

restoreToCount

Added in API level 1
void restoreToCount (int saveCount)
Efficient way to pop any calls to save() that happened after the save count reached saveCount. It is an error for saveCount to be less than 1. Example: int count = canvas.save(); ... // more calls potentially to save() canvas.restoreToCount(count); // now the canvas is back in the same state it was before the initial // call to save().

Parameters
saveCount	int: The save level to restore to.
rotate

Added in API level 1
void rotate (float degrees, 
                float px, 
                float py)
Preconcat the current matrix with the specified rotation.

Parameters
degrees	float: The amount to rotate, in degrees
px	float: The x-coord for the pivot point (unchanged by the rotation)
py	float: The y-coord for the pivot point (unchanged by the rotation)
rotate

Added in API level 1
void rotate (float degrees)
Preconcat the current matrix with the specified rotation.

Parameters
degrees	float: The amount to rotate, in degrees
save

Added in API level 1
int save (int saveFlags)
Based on saveFlags, can save the current matrix and clip onto a private stack.

Note: if possible, use the parameter-less save(). It is simpler and faster than individually disabling the saving of matrix or clip with this method.

Subsequent calls to translate,scale,rotate,skew,concat or clipRect, clipPath will all operate as usual, but when the balancing call to restore() is made, those calls will be forgotten, and the settings that existed before the save() will be reinstated.

Parameters
saveFlags	int: flag bits that specify which parts of the Canvas state to save/restore
Returns
int	The value to pass to restoreToCount() to balance this save()
save

Added in API level 1
int save ()
Saves the current matrix and clip onto a private stack.

Subsequent calls to translate,scale,rotate,skew,concat or clipRect, clipPath will all operate as usual, but when the balancing call to restore() is made, those calls will be forgotten, and the settings that existed before the save() will be reinstated.

Returns
int	The value to pass to restoreToCount() to balance this save()
saveLayer

Added in API level 21
int saveLayer (float left, 
                float top, 
                float right, 
                float bottom, 
                Paint paint)
Convenience for saveLayer(left, top, right, bottom, paint, ALL_SAVE_FLAG)

Parameters
left	float
top	float
right	float
bottom	float
paint	Paint
Returns
int	
saveLayer

Added in API level 1
int saveLayer (RectF bounds, 
                Paint paint, 
                int saveFlags)
This behaves the same as save(), but in addition it allocates and redirects drawing to an offscreen bitmap.

Note: this method is very expensive, incurring more than double rendering cost for contained content. Avoid using this method, especially if the bounds provided are large, or if the CLIP_TO_LAYER_SAVE_FLAG is omitted from the saveFlags parameter. It is recommended to use a hardware layer on a View to apply an xfermode, color filter, or alpha, as it will perform much better than this method.

All drawing calls are directed to a newly allocated offscreen bitmap. Only when the balancing call to restore() is made, is that offscreen buffer drawn back to the current target of the Canvas (either the screen, it's target Bitmap, or the previous layer).

Attributes of the Paint - alpha, Xfermode, and ColorFilter are applied when the offscreen bitmap is drawn back when restore() is called.

Parameters
bounds	RectF: May be null. The maximum size the offscreen bitmap needs to be (in local coordinates)
paint	Paint: This is copied, and is applied to the offscreen when restore() is called.
saveFlags	int: see _SAVE_FLAG constants, generally ALL_SAVE_FLAG is recommended for performance reasons.
Returns
int	value to pass to restoreToCount() to balance this save()
saveLayer

Added in API level 21
int saveLayer (RectF bounds, 
                Paint paint)
Convenience for saveLayer(bounds, paint, ALL_SAVE_FLAG)

Parameters
bounds	RectF
paint	Paint
Returns
int	
saveLayer

Added in API level 1
int saveLayer (float left, 
                float top, 
                float right, 
                float bottom, 
                Paint paint, 
                int saveFlags)
Helper version of saveLayer() that takes 4 values rather than a RectF.

Parameters
left	float
top	float
right	float
bottom	float
paint	Paint
saveFlags	int
Returns
int	
saveLayerAlpha

Added in API level 1
int saveLayerAlpha (float left, 
                float top, 
                float right, 
                float bottom, 
                int alpha, 
                int saveFlags)
Helper for saveLayerAlpha() that takes 4 values instead of a RectF.

Parameters
left	float
top	float
right	float
bottom	float
alpha	int
saveFlags	int
Returns
int	
saveLayerAlpha

Added in API level 1
int saveLayerAlpha (RectF bounds, 
                int alpha, 
                int saveFlags)
This behaves the same as save(), but in addition it allocates and redirects drawing to an offscreen bitmap.

Note: this method is very expensive, incurring more than double rendering cost for contained content. Avoid using this method, especially if the bounds provided are large, or if the CLIP_TO_LAYER_SAVE_FLAG is omitted from the saveFlags parameter. It is recommended to use a hardware layer on a View to apply an xfermode, color filter, or alpha, as it will perform much better than this method.

All drawing calls are directed to a newly allocated offscreen bitmap. Only when the balancing call to restore() is made, is that offscreen buffer drawn back to the current target of the Canvas (either the screen, it's target Bitmap, or the previous layer).

The alpha parameter is applied when the offscreen bitmap is drawn back when restore() is called.

Parameters
bounds	RectF: The maximum size the offscreen bitmap needs to be (in local coordinates)
alpha	int: The alpha to apply to the offscreen when it is drawn during restore()
saveFlags	int: see _SAVE_FLAG constants, generally ALL_SAVE_FLAG is recommended for performance reasons.
Returns
int	value to pass to restoreToCount() to balance this call
saveLayerAlpha

Added in API level 21
int saveLayerAlpha (float left, 
                float top, 
                float right, 
                float bottom, 
                int alpha)
Helper for saveLayerAlpha(left, top, right, bottom, alpha, ALL_SAVE_FLAG)

Parameters
left	float
top	float
right	float
bottom	float
alpha	int
Returns
int	
saveLayerAlpha

Added in API level 21
int saveLayerAlpha (RectF bounds, 
                int alpha)
Convenience for saveLayerAlpha(bounds, alpha, ALL_SAVE_FLAG)

Parameters
bounds	RectF
alpha	int
Returns
int	
scale

Added in API level 1
void scale (float sx, 
                float sy, 
                float px, 
                float py)
Preconcat the current matrix with the specified scale.

Parameters
sx	float: The amount to scale in X
sy	float: The amount to scale in Y
px	float: The x-coord for the pivot point (unchanged by the scale)
py	float: The y-coord for the pivot point (unchanged by the scale)
scale

Added in API level 1
void scale (float sx, 
                float sy)
Preconcat the current matrix with the specified scale.

Parameters
sx	float: The amount to scale in X
sy	float: The amount to scale in Y
setBitmap

Added in API level 1
void setBitmap (Bitmap bitmap)
Specify a bitmap for the canvas to draw into. All canvas state such as layers, filters, and the save/restore stack are reset with the exception of the current matrix and clip stack. Additionally, as a side-effect the canvas' target density is updated to match that of the bitmap.

Parameters
bitmap	Bitmap: Specifies a mutable bitmap for the canvas to draw into.
See also:

setDensity(int)
getDensity()
setDensity

Added in API level 4
void setDensity (int density)
Specifies the density for this Canvas' backing bitmap. This modifies the target density of the canvas itself, as well as the density of its backing bitmap via Bitmap.setDensity(int).

Parameters
density	int: The new target density of the canvas, which is used to determine the scaling factor when drawing a bitmap into it. Use DENSITY_NONE to disable bitmap scaling.
See also:

getDensity()
setDensity(int)
setDrawFilter

Added in API level 1
void setDrawFilter (DrawFilter filter)
Parameters
filter	DrawFilter
setMatrix

Added in API level 1
void setMatrix (Matrix matrix)
Completely replace the current matrix with the specified matrix. If the matrix parameter is null, then the current matrix is reset to identity. Note: it is recommended to use concat(Matrix), scale(float, float), translate(float, float) and rotate(float) instead of this method.

Parameters
matrix	Matrix: The matrix to replace the current matrix with. If it is null, set the current matrix to identity.
See also:

concat(Matrix)
skew

Added in API level 1
void skew (float sx, 
                float sy)
Preconcat the current matrix with the specified skew.

Parameters
sx	float: The amount to skew in X
sy	float: The amount to skew in Y
translate

Added in API level 1
void translate (float dx, 
                float dy)
Preconcat the current matrix with the specified translation

Parameters
dx	float: The distance to translate in X
dy	float: The distance to translate in Y