from PIL import Image
import os
from resizeimage import resizeimage


directory = r'../src/main/resources/com/twitchEmotes/'
for filename in os.listdir(directory):
    if filename.endswith(".png") or filename.endswith(".png"):
        path = os.path.join(directory, filename)
        with open(path, 'r+b') as f:
            with Image.open(f) as image:
                cover = resizeimage.resize_cover(image, [15, 15])
                cover.save(path, image.format)

